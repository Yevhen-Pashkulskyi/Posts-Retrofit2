package org.example.controller;

import org.example.model.PostModel;
import org.example.view.PostView;

public class PostController {
    PostModel model;
    PostView view;

    public PostController(PostModel model, PostView view) {
        this.model = model;
        this.view = view;
    }

    public void getAllPosts(){
        view.displayAllPosts(model.fetchPosts());
    }
    public void getPostById(int id){
        view.displayPost(model.fetchPostById(id));
    }
}

