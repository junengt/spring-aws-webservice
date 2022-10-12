package com.example.springawswebservice.domain.user;

import com.example.springawswebservice.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "Users")
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long userId;

    @Column(name = "users_name", nullable = false)
    private String name;

    @Column(name = "users_email", nullable = false)
    private String email;

    @Column(name = "users_picture")
    private String picture;

    @Column(name = "users_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
