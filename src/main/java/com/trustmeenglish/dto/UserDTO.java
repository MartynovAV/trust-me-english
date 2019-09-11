package com.trustmeenglish.dto;

import com.trustmeenglish.model.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private Set<RoleDTO> roles;



}
