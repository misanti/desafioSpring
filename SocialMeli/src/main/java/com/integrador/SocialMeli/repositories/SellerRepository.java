package com.integrador.SocialMeli.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.SocialMeli.dto.SellerDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class SellerRepository implements ISellerRepository {

    List<SellerDTO> seller;

    public SellerRepository() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            seller = Arrays.asList(mapper.readValue(new ClassPathResource("sellers.json").getFile(), SellerDTO[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SellerDTO> getSellers() {
        return seller;
    }

    @Override
    public SellerDTO getSellerById(Integer userId) {

        SellerDTO seller = this.getSellers().stream()
                .filter(sellerId -> sellerId.getUserId() == userId)
                .findFirst().get();
        return seller;

    }
    @Override
    public SellerDTO getFollowersBySellerId(Integer userId) {

        SellerDTO seller = this.getSellers().stream()
                .filter(sellerId -> sellerId.getUserId() == userId)
                .findFirst().get();
        seller.getFollowers().stream().findAny();
        return seller;

    }

}
