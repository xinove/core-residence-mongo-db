package com.core.residence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "usuarios")
public class User {
    @Id
    private String id;
    private String name;
    private String password;
    private String email;
    
    private AccessUser accessUser;
}