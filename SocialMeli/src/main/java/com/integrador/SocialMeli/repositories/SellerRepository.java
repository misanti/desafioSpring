package com.integrador.socialmeli.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.socialmeli.dto.SellerDTO;
import com.integrador.socialmeli.dto.SellerWithFollowersDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class SellerRepository implements ISellerRepository {

   private List<SellerWithFollowersDTO> seller;
    // Cambiar el DTO al model Seller
    public SellerRepository() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            seller = Arrays.asList(mapper.readValue(new ClassPathResource("sellers.json").getFile(), SellerWithFollowersDTO[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SellerWithFollowersDTO> obtainSellersWithFollowers() {
        return seller;
    }

    @Override
    public SellerWithFollowersDTO obtainSellerWithFollowersById(Integer userId) {
        return this.obtainSellersWithFollowers().stream()
                .filter(sellerId -> sellerId.getUserId() == userId)
                .findFirst().get();
    }

    @Override
    public SellerDTO obtainSellerById(Integer userId) {
        SellerWithFollowersDTO seller = this.obtainSellerWithFollowersById(userId);
        return this.changeInstance(seller);
    }

    @Override
    public SellerDTO changeInstance(SellerWithFollowersDTO seller) {
        // Creo una instancia de SellerDTO y seteo los valores
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setFollowersCount(seller.getFollowers().size());
        sellerDTO.setUserId(seller.getUserId());
        sellerDTO.setUserName(seller.getUserName());
        return sellerDTO;
    }

}
