package org.example.model;

import org.example.entity.Post;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;

public class PostView {
    public void displayAllPosts(Optional<Response<List<Post>>> listResponse) {
    }

    public void displayPost(Optional<Response<Post>> postResponse) {
    }
}
