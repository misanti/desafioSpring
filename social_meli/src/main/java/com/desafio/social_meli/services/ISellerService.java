package com.desafio.social_meli.services;

import com.desafio.social_meli.dtos.SellerWithFollowerCountDTO;
import com.desafio.social_meli.dtos.SellerWithFollowersDTO;

import java.util.List;

public interface ISellerService {
    SellerWithFollowerCountDTO getQuantityFollowersBySellerId(Integer sellerId);
    SellerWithFollowersDTO getFollowersBySellerId(Integer sellerId, String order);
}
