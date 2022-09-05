package com.denys_bereza.test_app.services;

import com.denys_bereza.test_app.models.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    public List<Post> getFeeds(String userID);

    public Post createPost(String text, UUID userID);
}
