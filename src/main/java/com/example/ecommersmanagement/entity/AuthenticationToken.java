package com.example.ecommersmanagement.entity;

import io.jsonwebtoken.Jwts;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "token")
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String token;
    @Column(name = "created_date")
    private Date createdDate;


    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
//    Map<String, Object> claims=new HashMap<String,Object>();
//    claims.put
//    String token1= Jwts.builder().setHeaderParam("alg","RS256").setHeaderParam("typ","JWT")
//
//            .setClaims(claims)
    public AuthenticationToken(User user){
        this.user= user;
        this.createdDate=new Date();
        this.token= UUID.randomUUID().toString();
    }


}
