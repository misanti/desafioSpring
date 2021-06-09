package com.integrador.socialmeli.services;

import com.integrador.socialmeli.dto.SellerDTO;
import com.integrador.socialmeli.dto.SellerWithFollowersDTO;
import com.integrador.socialmeli.repositories.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService implements ISellerService {

    @Autowired
    private ISellerRepository sellerRepository;

    @Override
    public SellerDTO getSeller(Integer userId) {
        return sellerRepository.getSellerById(userId);
    }

    @Override
    public SellerWithFollowersDTO getFollowersBySellerId(Integer userId) {
        return sellerRepository.getSellerWithFollowersById(userId);
    }

    @Override
    public void newPost() {

    }

}