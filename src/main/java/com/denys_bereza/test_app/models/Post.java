package com.denys_bereza.test_app.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column(updatable = false)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(nullable = false, length=150)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable=false)
    private User user;

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
