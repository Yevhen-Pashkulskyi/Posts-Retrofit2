package org.example.model;

import org.example.entity.Post;
import org.example.network.ApiClient;
import org.example.network.ApiService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
public class PostModel {
    public Optional<Response<List<Post>>> fetchAllPosts() {
        ApiService service = ApiClient.getApiService();
        Call<List<Post>> call = service.getAllPosts();
        try {
            return Optional.of(call.execute());
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
    public Optional<Response<Post>> fetchPostById(int id) {
        ApiService service = ApiClient.getApiService();
        Call<Post> call = service.getPostById(id);
        try {
            return Optional.of(call.execute());
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
