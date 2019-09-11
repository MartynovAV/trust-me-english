package com.trustmeenglish.controllers;

import com.trustmeenglish.dto.RoleDTO;
import com.trustmeenglish.dto.UserDTO;
import com.trustmeenglish.model.Role;
import com.trustmeenglish.model.User;
import com.trustmeenglish.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public UserDTO sayHello(@PathVariable Long id){
        User user = userService.getUser(id);
        return toDTO(user);
    }

    private UserDTO toDTO(User user){
        Set<RoleDTO> roleDTOS = toDTOs(user.getRoles());
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .roles(roleDTOS)
                .build();
    }

    private Set<RoleDTO> toDTOs(Set<Role> role){
        return role.stream().map(role1 -> toDTOs(role1)).collect(Collectors.toSet());
    }

    private RoleDTO toDTOs(Role role){
       return RoleDTO.builder()
               .id(role.getId())
               .name(role.getName())
               .build();
    }
}
