package com.desafio.social_meli.models;


import com.desafio.social_meli.dtos.SellerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {
    private Integer userId;
    private String userName;
    private ArrayList<SellerDTO> followed; // lista con vendedores que sigue a un determinado comprador
  //  private ArrayList<Seller> followed; // lista con vendedores que sigue a un determinado comprador

   /* public void followSeller(Seller followed) {
        this.followed.add(followed);
    }
    public void unfollowSeller(Seller follower) {
        this.followed.remove(follower);
    }*/
    public void followSeller(SellerDTO followed) {
        this.followed.add(followed);
    }
    public void unfollowSeller(SellerDTO follower) {
        this.followed.remove(follower);
    }
}