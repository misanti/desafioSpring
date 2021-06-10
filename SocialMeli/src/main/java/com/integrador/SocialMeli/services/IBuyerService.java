package com.integrador.socialmeli.services;

import com.integrador.socialmeli.dto.BuyerWithFollowedDTO;

public interface IBuyerService {
     void followSeller(Integer buyerId, Integer sellerId);
     void unfollowSeller(Integer buyerId, Integer sellerId);
     BuyerWithFollowedDTO obtainBuyerWithFollowedById(Integer userId, String order);
     BuyerWithFollowedDTO obtainBuyerWithFollowedById(Integer userId);
}
