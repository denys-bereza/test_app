package com.denys_bereza.test_app.services;

import com.denys_bereza.test_app.models.Post;
import com.denys_bereza.test_app.models.User;
import com.denys_bereza.test_app.repositories.FeedNoSQLRepository;
import com.denys_bereza.test_app.repositories.PostRepository;
import com.denys_bereza.test_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository repository;
    private UserRepository userRepository;
    private FeedNoSQLRepository feedRepository;

    @Autowired
    public PostServiceImpl(PostRepository repository, UserRepository userRepository, FeedNoSQLRepository feedRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.feedRepository = feedRepository;
    }

    @Override
    public List<Post> getFeeds(String userID) {
        User user = userRepository.getReferenceById(UUID.fromString(userID));
        List<String> feedIDs = feedRepository.getFeed(user);
        List<UUID> ids = feedIDs.stream().map(UUID::fromString).collect(Collectors.toList());

        return repository.findAllById(ids);
    }

    @Override
    public Post createPost(String text, UUID userID) {
        User user = this.userRepository.getReferenceById(userID);

        Post post = new Post(text, user);
        this.repository.save(post);

        // TODO:
        //   Fetch Active followers only
        List<User> followers = user.getFollowers();
        //   Put tweet into redis for each user
        for (User f: followers) {
            // TODO: it should be moved into separate nonblocking background process
            //   process might be notified by some messaging system RabbitMQ, AWS SQS...
            feedRepository.addToUserFeed(f, post.getId());
        }

        return post;
    }
}
