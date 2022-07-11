package com.server.reactive.domain.services;

import com.server.reactive.domain.entities.Role;
import com.server.reactive.domain.entities.UserCredential;

import java.util.List;

public interface UserService {
    UserCredential saveUser(UserCredential userCredential);
    Role saveRole(Role role);
    void addRoleToUser(String userName,String roleName);
    UserCredential getUser(String userName);
    List<UserCredential> getUser();
}
