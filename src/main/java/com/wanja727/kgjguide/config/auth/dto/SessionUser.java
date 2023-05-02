package com.wanja727.kgjguide.config.auth.dto;

import com.wanja727.kgjguide.entity.Users;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class SessionUser implements Serializable {
    private static final long serialVersionUID = 6423684360384848911L;

    private String name;
    private String email;
    private String picture;
    private Long userId;

    public SessionUser(Users user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
        this.userId = user.getUserId();
    }
}
