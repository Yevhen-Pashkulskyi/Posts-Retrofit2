package org.example.model;

import org.example.entity.Post;
import org.example.network.ApiClient;
import org.example.network.ApiService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
public class PostModel {

    private ApiService service = ApiClient.getApiService();

    public List<Post> fetchPosts() {
        try {
            Call<List<Post>> call = service.getAllPosts();
            Response<List<Post>> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                System.out.println("Failed to fetch posts: " + response.code());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Post fetchPostById(int id) {
        try {
            Call<Post> call = service.getPostById(id);
            Response<Post> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                System.out.println("Failed to fetch post with ID: " + id + " Status code: " + response.code());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}

