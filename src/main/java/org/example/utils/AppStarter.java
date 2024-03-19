package org.example.utils;

import org.example.controller.AppController;
import org.example.model.PostModel;
import org.example.view.MenuView;
import org.example.view.PostView;

public class AppStarter {

    public static void start() {
        PostModel model = new PostModel();
        MenuView menuView = new MenuView();
        PostView postView = new PostView();
        AppController controller = new AppController(model, menuView, postView);

        controller.runApplication();
    }
}
