package org.example.view;

import org.example.entity.Post;
import org.example.utils.Constants;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PostView {

    Scanner scanner = new Scanner(System.in);

    public void displayAllPosts(List<Post> posts) {
        if (posts != null && !posts.isEmpty()) {
            for (Post post : posts) {
                System.out.println("Post ID: " + post.getId());
                System.out.println("Title: " + post.getTitle());
                System.out.println("Body: " + post.getBody());
                System.out.println();
            }
        } else {
            System.out.println(Constants.NO_DATA_MSG);
        }
    }

    public void displayPost(Post post) {
        if (post != null) {
            System.out.println("Post ID: " + post.getId());
            System.out.println("Title: " + post.getTitle());
            System.out.println("Body: " + post.getBody());
        } else {
            System.out.println(Constants.NO_DATA_MSG);
        }
    }
}