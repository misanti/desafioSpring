package com.integrador.socialmeli.services;

import com.integrador.socialmeli.dto.SellerDTO;
import com.integrador.socialmeli.dto.SellerWithFollowersDTO;


public interface ISellerService {
    public SellerDTO getSeller(Integer userId);
    public SellerWithFollowersDTO getFollowersBySellerId(Integer userId);
    public void newPost();

}
