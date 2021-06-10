package com.integrador.socialmeli.services;

import com.integrador.socialmeli.dto.BuyerDTO;
import com.integrador.socialmeli.dto.SellerDTO;
import com.integrador.socialmeli.dto.SellerWithFollowersDTO;
import com.integrador.socialmeli.model.Post;
import com.integrador.socialmeli.repositories.IPostRepository;
import com.integrador.socialmeli.repositories.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class SellerService implements ISellerService {

    private static final String ORDER_ASC = "name_asc";
    private static final String ORDER_DESC = "name_desc";

    @Autowired
    private ISellerRepository sellerRepository;
    @Autowired
    private IPostRepository postRepository;


    @Override
    public SellerDTO obtainSeller(Integer userId) {
        return sellerRepository.obtainSellerById(userId);
    }

    @Override
    public SellerWithFollowersDTO obtainFollowersBySellerId(Integer userId, String order) {
        SellerWithFollowersDTO seller = sellerRepository.obtainSellerWithFollowersById(userId);
        if (order != null) {
            this.orderBuyers(seller.getFollowers(), order);
        }
        return seller;
    }

    private void orderBuyers(List<BuyerDTO> buyers, String order) {
        if (ORDER_DESC.equals(order)) {
            Collections.sort(buyers, Comparator.comparing(BuyerDTO::getUserName).reversed());
        }
        if (ORDER_ASC.equals(order)) {
            Collections.sort(buyers, Comparator.comparing(BuyerDTO::getUserName));
        }
    }


}