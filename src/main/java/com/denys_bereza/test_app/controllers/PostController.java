package com.denys_bereza.test_app.controllers;

import com.denys_bereza.test_app.dto.GenericResponse;
import com.denys_bereza.test_app.dto.PostCreateDTO;
import com.denys_bereza.test_app.models.Post;
import com.denys_bereza.test_app.repositories.PostRepository;
import com.denys_bereza.test_app.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    final String PostPath = "/posts";

    private PostService service;
    private PostRepository repository;

    @Autowired
    public PostController(PostService service, PostRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @RequestMapping(
            value = PostPath,
            method = RequestMethod.POST,
            produces="application/json",
            consumes="application/json"
    )
    @ResponseBody
    public GenericResponse<Post> createPost(@RequestBody PostCreateDTO postData) {
        Post post = this.service.createPost(postData.getText(), postData.getUserID());
        return new GenericResponse<Post>(true, "Created").withData(post);
    }

    @RequestMapping(
            value = PostPath +"/{id}",
            method = RequestMethod.GET,
            produces="application/json"
    )
    @ResponseBody
    public GenericResponse<List<Post>> getFeed(@PathVariable String id) {
        List<Post> posts = service.getFeeds(id);
        return new GenericResponse<List<Post>>(true, "Created").withData(posts);
    }
}
