package com.desafio.social_meli.services;

import com.desafio.social_meli.models.Buyer;

public interface IBuyerService {
    void followSeller(Integer buyerId, Integer sellerId);
    void unfollowSeller(Integer buyerId, Integer sellerId);
    Buyer getBuyerWithFollowedById(Integer userId, String order);
}
