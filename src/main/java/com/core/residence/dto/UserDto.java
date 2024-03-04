package com.core.residence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDto {

    private String username;
    private String password;
    private String email;

    // Getters y setters
}
