package com.wanja727.kgjguide.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString(exclude = {"user","cafe"})
public class Bookmark extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;
}
