package com.integrador.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyerWithFollowedDTO {
    private Integer userId;
    private String userName;
    private ArrayList<SellerDTO> followed; // lista con vendedores que sigue a un determinado comprador

    public void addFollowed(SellerDTO seller) {
        this.followed.add(seller);
    }
    public void unfollowSeller(SellerDTO seller) {
        this.followed.remove(seller);
    }

}
