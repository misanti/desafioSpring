package com.integrador.SocialMeli.services;

import com.integrador.SocialMeli.dto.SellerDTO;
import com.integrador.SocialMeli.repositories.ISellerRepository;
import com.integrador.SocialMeli.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService implements ISellerService {

    @Autowired
    private ISellerRepository sellerRepository;

    @Override

    //cambiar el nombre del metodo y devolver el SellerDTO.

   public SellerDTO getSeller(Integer userId) {
        // Seteo el numero de seguidores en followCount
        sellerRepository.getSellerById(userId).setFollowersCount(sellerRepository.getSellerById(userId).getFollowers().size());
        return sellerRepository.getSellerById(userId);
    }

    @Override
    public SellerDTO getFollowersBySellerId(Integer userId) {
        return sellerRepository.getFollowersBySellerId(userId);
    }


}