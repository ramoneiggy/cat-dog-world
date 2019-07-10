package com.isolaja.petproject.service.users;

import com.isolaja.petproject.model.entity.Role;
import com.isolaja.petproject.model.entity.User;
import com.isolaja.petproject.model.enums.RoleNames;
import com.isolaja.petproject.repository.RoleRepository;
import com.isolaja.petproject.repository.UserRepository;
import com.isolaja.petproject.security.PasswordConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordConfiguration passwordConfiguration;
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public User findByUsername(String username) {
        // check the database if the user already exists
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void save(User user) throws EntityExistsException {
        if (findByUsername(user.getUsername()) != null) {
            throw new EntityExistsException("Username is already taken.");
        }
        user.setId(0);
        user.setRoles(Collections.singletonList(roleRepository.findRoleByName(String.valueOf(RoleNames.ROLE_USER))));
        user.setRegistrationDate(LocalDateTime.now());
        user.setPassword(passwordConfiguration.passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
