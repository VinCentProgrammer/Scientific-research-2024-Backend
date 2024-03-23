package com.dungken.scientificresearch2024backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "comment")
    private String comment;

    @Column(name = "address")
    private String address;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "avatar", columnDefinition = "LONGTEXT")
    @Lob
    private String avatar;

    @Column(name = "active_code")
    private String activeCode;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.DETACH, CascadeType.REFRESH,
            CascadeType.PERSIST, CascadeType.MERGE,
    })
    @JoinTable(
            name = "user_thread",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "thread_id")
    )
    private List<Thread> threads;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.DETACH, CascadeType.REFRESH,
            CascadeType.PERSIST, CascadeType.MERGE,
    })
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.REFRESH,
            CascadeType.PERSIST, CascadeType.MERGE,
    })
    private List<Page> pages;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.REFRESH,
            CascadeType.PERSIST, CascadeType.MERGE,
    })
    private List<PostDetail> posts;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.REFRESH,
            CascadeType.PERSIST, CascadeType.MERGE,
    })
    private List<KnowledgeDetail> listKnowledge;
}
