package com.integrador.SocialMeli.repositories;

import com.integrador.SocialMeli.dto.BuyerDTO;
import com.integrador.SocialMeli.dto.SellerDTO;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IBuyerRespository {
    List<BuyerDTO> getBuyers();

    // Obtener seguidores por codigo de comprador - ID
   // SellerDTO getFollowersByBuyerId(Integer userId);
}
