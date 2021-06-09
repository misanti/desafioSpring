package com.integrador.socialmeli.services;

import com.integrador.socialmeli.dto.BuyerWithFollowedDTO;

public interface IBuyerService {
    public void followSeller(Integer buyerId, Integer sellerId);
    public void unfollowSeller(Integer buyerId, Integer sellerId);

    public BuyerWithFollowedDTO getBuyerWithFollowedById(Integer userId);
}
