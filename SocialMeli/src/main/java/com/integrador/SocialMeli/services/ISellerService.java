package com.integrador.socialmeli.services;

import com.integrador.socialmeli.dto.SellerDTO;
import com.integrador.socialmeli.dto.SellerWithFollowersDTO;
import com.integrador.socialmeli.model.Post;


public interface ISellerService {
    public SellerDTO obtainSeller(Integer userId);

    public SellerWithFollowersDTO obtainFollowersBySellerId(Integer userId, String order);




}
