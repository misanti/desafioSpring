package com.integrador.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyerDTO {
    private Integer userId;
    private String userName;
    private ArrayList<Integer> followed; // lista con vendedores que sigue a un determinado comprador

    public ArrayList<Integer> getFollowed() {
        return followed;
    }

    public void setFollowed(ArrayList<Integer> followed) {
        this.followed = followed;
    }

    public void setFollowedById(Integer sellerId) {
        this.followed.add(sellerId);
    }

}
