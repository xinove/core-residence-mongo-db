package com.core.residence.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Document(collection = "usuarios")
public class User {
    @Id
    private ObjectId id;
    private String name;
    private String password;
    private String email;
    
//    private List<AccessUser> accessUser;
}