package com.desafio.social_meli.models;

import com.desafio.social_meli.dtos.BuyerDTO;
import com.desafio.social_meli.dtos.SellerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seller {
    private Integer userId;
    private String userName;
    private ArrayList<BuyerDTO> followers;
    private Integer followers_count;


    public void addFollowers(BuyerDTO follower) {
        this.followers.add(follower);
    }
    public void removeBuyer(BuyerDTO follower) {
        this.followers.remove(follower);
    }


}
