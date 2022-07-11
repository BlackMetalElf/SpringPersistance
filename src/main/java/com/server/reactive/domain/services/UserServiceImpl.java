package com.server.reactive.domain.services;

import com.server.reactive.domain.entities.UserCredential;
import com.server.reactive.domain.repositories.UserRepository;
import com.server.reactive.domain.entities.Role;
import com.server.reactive.domain.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service @RequiredArgsConstructor @Transactional //@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredential user=userRepository.findByUsername(username);
        if(user==null){
            //log.error("User not found in database{}",username);
            throw new UsernameNotFoundException("User not found in database");
        }
        else{
            //log.info("User found in the database: {}",username);
        }

        Collection<SimpleGrantedAuthority> autorities= new ArrayList<>();
        user.getRoles().forEach(role->{
            autorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(user.getUsername(),user.getPassword(),autorities);
    }
    @Override
    public UserCredential saveUser(UserCredential userCredential) {
        //log.info("Saving new User {} in the database",userCredential.getName());
        return userRepository.save(userCredential);
    }
    @Override
    public Role saveRole(Role role) {
        //log.info("Saving new role {} to the database",role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        //log.info("Adding role {} to user {}",roleName,username);
        UserCredential userCredential =userRepository.findByUsername(username);
        Role role=roleRepository.findByName(roleName);
        userCredential.getRoles().add(role);

    }

    @Override
    public UserCredential getUser(String userName) {
        //log.info("Fetching user {}",userName);
        return userRepository.findByUsername(userName);
    }

    @Override
    public List<UserCredential> getUser() {
        //log.info("Fetch all users");
        return userRepository.findAll();
    }



}
