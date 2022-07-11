package com.server.reactive.domain.controller;

import com.server.reactive.domain.entities.Role;
import com.server.reactive.domain.entities.UserCredential;
import com.server.reactive.domain.forms.RoleToUserForm;
import com.server.reactive.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<UserCredential>>getUsers(){
        return ResponseEntity.ok().body(userService.getUser());
    }
    @PostMapping("/user/save")
    public ResponseEntity<UserCredential>saveUser(@RequestBody UserCredential userCredential){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(userCredential));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    @PostMapping("/role/addToUser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm roleToUserForm){
        userService.addRoleToUser(roleToUserForm.getUsername(), roleToUserForm.getRolename());
        return  ResponseEntity.ok().build();
    }

}
