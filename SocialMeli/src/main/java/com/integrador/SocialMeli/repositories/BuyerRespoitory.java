package com.integrador.socialmeli.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.socialmeli.dto.BuyerDTO;
import com.integrador.socialmeli.dto.BuyerWithFollowedDTO;
import com.integrador.socialmeli.dto.PostByBuyerDTO;
import com.integrador.socialmeli.model.Post;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class BuyerRespoitory implements IBuyerRespository {

    List<BuyerWithFollowedDTO> buyer;
    // Cambiar el DTO al model Buyer

    public BuyerRespoitory() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            buyer = Arrays.asList(mapper.readValue(new ClassPathResource("buyers.json").getFile(), BuyerWithFollowedDTO[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BuyerWithFollowedDTO> obtainBuyerWithFollowed() {
        return buyer;
    }

    @Override
    public BuyerWithFollowedDTO obtainBuyerWithFollowedById(Integer userId) {
        return this.obtainBuyerWithFollowed().stream()
                .filter(buyerId -> buyerId.getUserId() == userId)
                .findFirst().get();
    }

    @Override
    public BuyerDTO changeInstance(BuyerWithFollowedDTO buyer) {
        // Creo una instancia de Buyer y seteo los valores
        BuyerDTO buyerDTO = new BuyerDTO();
        buyerDTO.setUserId(buyer.getUserId());
        buyerDTO.setUserName(buyer.getUserName());
        return buyerDTO;
    }



}
