package com.integrador.socialmeli.services;

import com.integrador.socialmeli.dto.PostByBuyerDTO;
import com.integrador.socialmeli.model.Post;

import java.util.ArrayList;

public interface IPostService {
    void newPost(Post post);

    PostByBuyerDTO obtainPostBySellers(Integer buyerId, String order);
}
