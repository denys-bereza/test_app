package com.denys_bereza.test_app.repositories;

import com.denys_bereza.test_app.models.User;

import java.util.List;
import java.util.UUID;

public interface FeedNoSQLRepository {
    List<String> getFeed(User user);

    void addToUserFeed(User user, UUID postID);
}
