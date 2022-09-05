package com.denys_bereza.test_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "posts")
@JsonIgnoreProperties(value = { "user" })
public class Post {
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(nullable = false, length=150)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable=false)
    private User user;

    public Post() {}

    public Post(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() { return user; }
}
