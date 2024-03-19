package org.example.utils;

import org.example.entity.Post;
import org.example.network.ApiService;
import org.example.network.ApiClient;
import org.example.view.AppView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.Scanner;

public class ApplicationRunner {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AppView appView = new AppView();
    public static void run() {
        ApiService api = ApiClient.getApiService();
        boolean isRunning = true;

        while (isRunning) {
            String option = appView.chooseOption();
            switch (option) {
                case "1":
                    loadAllPosts(api);
                    break;
                case "2":
                    System.out.print("Enter post ID: ");
                    int postId = scanner.nextInt(); // Get user input for post ID
                    scanner.nextLine(); // Consume newline left-over
                    loadPostById(api, postId);
                    break;
                case "0":
                    appView.getOutput(Constants.APP_CLOSED_MSG, option);
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void loadPostById(ApiService api, int postId) {
        Call<Post> call = api.getPostById(postId);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }
                Post post = response.body();
                System.out.println("Post ID: " + post.getId());
                System.out.println("Title: " + post.getTitle());
                System.out.println("Body: " + post.getBody());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private static void loadAllPosts(ApiService api) {
        Call<List<Post>> callAll = api.getAllPosts();
        callAll.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post : posts) {
                    System.out.println("Post ID: " + post.getId());
                    System.out.println("Title: " + post.getTitle());
                    System.out.println("Body: " + post.getBody());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
