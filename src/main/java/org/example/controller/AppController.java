package org.example.controller;

import org.example.entity.Post;
import org.example.model.PostModel;
import org.example.utils.Constants;
import org.example.view.MenuView;
import org.example.view.PostView;

import java.util.Collections;
import java.util.List;

public class AppController {

    private final PostModel model;
    private final MenuView menuView;
    private final PostView postView;

    public AppController(PostModel model, MenuView menuView, PostView postView) {
        this.model = model;
        this.menuView = menuView;
        this.postView = postView;
    }

    public void runApplication() {
        boolean running = true;
        while (running) {
            int choice = menuView.displayMenuAndGetChoice();
            switch (choice) {
                case 1:
                    List<Post> allPosts = model.fetchPosts();
                    postView.displayAllPosts(allPosts);
                    break;
                case 2:
                    int id = menuView.getPostId();
                    Post post = model.fetchPostById(id);
                    postView.displayPost(post);
                    break;
                case 0:
                    running = false;
                    System.out.println(Constants.APP_CLOSED_MSG);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}