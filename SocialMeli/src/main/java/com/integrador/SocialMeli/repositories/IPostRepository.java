package com.integrador.socialmeli.repositories;

import com.integrador.socialmeli.dto.PostByBuyerDTO;
import com.integrador.socialmeli.model.Post;

import java.util.ArrayList;
import java.util.List;

public interface IPostRepository {
    List<Post> obtainAllPost();

    // ver que devuelvo
    void savePost(Post post);

    List<Post> findAllByUserId(Integer userId);

}
