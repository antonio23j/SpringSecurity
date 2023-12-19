package com.example.spring_securityv2.models;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@NoArgsConstructor
public class UserDAO {

    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String email;
    private String password;

    public UserDAO(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
