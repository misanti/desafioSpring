package com.integrador.SocialMeli.services;

import com.integrador.SocialMeli.dto.SellerDTO;


public interface ISellerService {
    public SellerDTO getSeller(Integer userId);
    public SellerDTO getFollowersBySellerId(Integer userId);

}
