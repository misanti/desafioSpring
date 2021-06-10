package com.integrador.socialmeli.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.socialmeli.dto.PostByBuyerDTO;
import com.integrador.socialmeli.model.Post;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository

public class PostRepository implements IPostRepository {
    private List<Post> posts;

    // poner private todas las de los otros repositorios
    public PostRepository() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            posts = new ArrayList<>(Arrays.asList(mapper.readValue(new ClassPathResource("post.json").getFile(), Post[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> obtainAllPost() {
        return posts;
    }

    @Override
    public void savePost(Post post) {
        // guardar aca las publicaciones
        // agregar validaciones
        posts.add(post);
    }

    @Override
    public List<Post> findAllByUserId(Integer userId) {
        return this.posts.stream()
                .filter(post -> post.getUserId().equals(userId))
                .collect(Collectors.toList());
    }


}
