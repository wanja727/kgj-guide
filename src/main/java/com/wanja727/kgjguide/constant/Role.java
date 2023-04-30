package com.wanja727.kgjguide.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
//    ROLE_USER,ROLE_ADMIN
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER","유저"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;
}
