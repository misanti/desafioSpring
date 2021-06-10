package com.integrador.socialmeli.dto;

import com.integrador.socialmeli.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostByBuyerDTO {
    private Integer userId;
    private List<Post> posts;

}
