package org.example.controller;
import org.example.model.PostModel;
import org.example.view.MenuView;
import org.example.view.PostView;

public class AppController {

    private final PostModel model;
    private final PostView view;
    private final MenuView menuView;
    private final PostController postController;

    public AppController(PostModel model, PostView view, MenuView menuView) {
        this.model = model;
        this.view = view;
        this.menuView = menuView;
        this.postController = new PostController(model, view);
    }

    public void runApplication() {
        boolean running = true;
        while (running) {
            int choice = menuView.displayMenuAndGetChoice();
            switch (choice) {
                case 1:
                    postController.getAllPosts();
                    break;
                case 2:
                    int id = menuView.getPostId();
                    postController.getPostById(id);
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting the application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}