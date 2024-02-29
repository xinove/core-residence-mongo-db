package com.core.residence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class User {
    @Id
    private String id;
    private String nombre;
    private String email;
    
//    private AccessUser accessUser;
    // Otros campos y métodos getters/setters
}