package com.desafio.social_meli.util;

import com.desafio.social_meli.dtos.BuyerDTO;
import com.desafio.social_meli.dtos.SellerDTO;
import com.desafio.social_meli.dtos.SellerWithFollowersDTO;
import com.desafio.social_meli.models.Buyer;
import com.desafio.social_meli.models.Seller;
import com.desafio.social_meli.repositories.buyer.IBuyerRepository;
import com.desafio.social_meli.repositories.seller.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NewInstance {

    //region Autowired repositories
    @Autowired
    private static IBuyerRepository buyerRepository;
    @Autowired
    private static ISellerRepository sellerRepository;
    //endregion Autowired repositories

    //region BuyerDTO
    public static BuyerDTO newBuyerInstance(Integer buyerId) {
        Buyer buyer = buyerRepository.findById(buyerId);
        BuyerDTO buyerDTO = new BuyerDTO();
        buyerDTO.setUserId(buyer.getUserId());
        buyerDTO.setUserName(buyer.getUserName());
        return buyerDTO;
    }
    //endregion BuyerDTO

    //region SellerDTO
    public static SellerDTO newSellerInstance(Integer sellerId) {
        Seller seller = sellerRepository.findById(sellerId);
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setUserId(seller.getUserId());
        sellerDTO.setUserName(seller.getUserName());
        return sellerDTO;
    }
    //endregion SellerDTO

    //region SellerWithFollowersDTO
    public static SellerWithFollowersDTO newSellerWithFollowersDTOInstance(Integer sellerId) {
        Seller seller = sellerRepository.findById(sellerId);
        SellerWithFollowersDTO sellerWithFollowers = new SellerWithFollowersDTO();
        sellerWithFollowers.setUserId(seller.getUserId());
        sellerWithFollowers.setUserName(seller.getUserName());
        sellerWithFollowers.setFollowers(seller.getFollowers());
        return sellerWithFollowers;
    }
    //endregion SellerWithFollowersDTO

}
