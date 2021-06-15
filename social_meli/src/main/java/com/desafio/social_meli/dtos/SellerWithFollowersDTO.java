package com.desafio.social_meli.dtos;

import com.desafio.social_meli.models.Buyer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerWithFollowersDTO {
    private Integer userId;
    private String userName;
    private ArrayList<BuyerDTO> followers;

    public SellerWithFollowersDTO(Integer userId, String userName, int size) {
    }
}
