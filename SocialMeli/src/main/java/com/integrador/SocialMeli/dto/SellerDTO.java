package com.integrador.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDTO {
    private Integer userId;
    private String userName;
    private ArrayList<Integer> followers; // lista con usuarios que siguen a un determinado vendedor
    private ArrayList<PostDTO> post; // lista de publicaciones que hizo el vendedor
    private Integer followersCount; // cantidad de seguidores que tiene el vendedor

    public void setFollower(Integer buyerId) {
        this.followers.add(buyerId);
    }
}
