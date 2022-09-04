package com.denys_bereza.test_app.services;

import com.denys_bereza.test_app.models.Post;
import com.denys_bereza.test_app.models.User;

import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService {
    @Override
    public List<Post> getFeeds(User user) {
        // TODO: Get feed IDs from Redis service
        //    Fetch records from DB
        return new ArrayList<>();
    }

    @Override
    public void createPost(User user, Post post) {
        // TODO: Create record into DB, get id
        //      Fetch active followers
        //      Put feed into redis for each user
    }
}
