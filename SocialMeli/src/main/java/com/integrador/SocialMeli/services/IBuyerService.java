package com.integrador.SocialMeli.services;

import com.integrador.SocialMeli.dto.BuyerDTO;
import com.integrador.SocialMeli.dto.SellerDTO;

import java.util.ArrayList;

public interface IBuyerService {
    public BuyerDTO followSeller(Integer buyerId, Integer sellerId);

}
