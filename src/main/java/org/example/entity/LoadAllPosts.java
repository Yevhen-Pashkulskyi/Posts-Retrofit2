package org.example.entity;

import org.example.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class LoadAllPosts {
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
