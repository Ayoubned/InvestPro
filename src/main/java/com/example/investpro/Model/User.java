package com.example.investpro.Model;

import jakarta.persistence.*;
import lombok.*;
//import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

//@Data
//@Document(collection = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String username;
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

}

