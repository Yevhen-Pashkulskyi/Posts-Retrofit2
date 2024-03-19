package org.example.utils;

import org.example.controller.AppController;
import org.example.model.PostModel;
import org.example.view.MenuView;
import org.example.view.PostView;

public class AppStarter {

    public static void start() {
        PostModel model = new PostModel();
        PostView view = new PostView();
        MenuView menuView = new MenuView();
        AppController controller = new AppController(model, view, menuView);

        controller.runApplication();
    }
}