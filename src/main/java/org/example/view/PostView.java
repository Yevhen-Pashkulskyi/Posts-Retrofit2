package org.example.view;

import org.example.entity.Post;
import org.example.utils.Constants;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PostView {

    Scanner scanner = new Scanner(System.in);

    public void displayAllPosts(Optional<Response<List<Post>>> optional) {
        if (optional.isPresent() && optional.get().isSuccessful()) {
            List<Post> posts = optional.get().body();
            posts.forEach(post -> System.out.println(post.getTitle()));
        } else {
            System.out.println(Constants.NO_DATA_MSG);
        }
    }

    public void displayPost(Optional<Response<Post>> optional) {
        if (optional.isPresent() && optional.get().isSuccessful()) {
            Post post = optional.get().body();
            System.out.println(post.getTitle());
        } else {
            System.out.println(Constants.NO_DATA_MSG);
        }
    }
}