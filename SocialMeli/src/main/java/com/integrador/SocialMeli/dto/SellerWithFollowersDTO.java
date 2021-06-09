package com.integrador.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerWithFollowersDTO {
    private Integer userId;
    private String userName;
    private ArrayList<BuyerDTO> followers; // lista con usuarios que siguen a un determinado vendedor

    // cambiar nombres 
    public void setFollower(BuyerDTO follower) {
        this.followers.add(follower);
    }
    public void setUnfollower(BuyerDTO follower) {
        this.followers.remove(follower);
    }

}
