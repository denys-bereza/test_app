package com.denys_bereza.test_app.repositories;

import com.denys_bereza.test_app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class FeedRedisRepositoryImpl implements FeedNoSQLRepository {

    @Autowired
    private RedisTemplate<String, String> template;

    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

    @Override
    public List<String> getFeed(User user) {
        return listOps.range(feedKey(user), 1, 1000);
    }

    @Override
    public void addToUserFeed(User user, UUID postID) {
        listOps.rightPush(feedKey(user), postID.toString());
    }

    private String feedKey(User user) {
        return "Feeds::"
                + user.getRegion().toString() + "::"
                + user.getId().toString();
    }
}
