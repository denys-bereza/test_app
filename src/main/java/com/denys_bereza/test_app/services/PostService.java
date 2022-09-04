package com.denys_bereza.test_app.services;

import com.denys_bereza.test_app.models.Post;
import com.denys_bereza.test_app.models.User;

import java.util.List;

public interface PostService {
    public List<Post> getFeeds(User user);

    public void createPost(User user, Post post);
}
