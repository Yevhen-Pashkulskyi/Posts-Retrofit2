package org.example.network;

import org.example.entity.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {
    @GET("posts")
    Call<List<Post>> getAllPosts();

    @GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int id);
}
