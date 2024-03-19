package org.example.utils;
import org.example.controller.PostController;
import org.example.model.PostModel;
import org.example.view.MenuView;
import org.example.view.PostView;

public class AppStarter {

    public static void start() {
        PostModel model = new PostModel();
        PostView view = new PostView();
        MenuView menuView = new MenuView();
        PostController controller = new PostController(model, view);

        boolean running = true;
        while (running) {
            int choice = menuView.displayMenuAndGetChoice();
            switch (choice) {
                case 1:
                    controller.getAllPosts();
                    break;
                case 2:
                    int id = menuView.getPostId();
                    controller.getPostById(id);
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