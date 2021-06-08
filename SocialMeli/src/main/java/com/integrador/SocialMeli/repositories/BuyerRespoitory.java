package com.integrador.SocialMeli.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.SocialMeli.dto.BuyerDTO;
import com.integrador.SocialMeli.dto.SellerDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class BuyerRespoitory implements IBuyerRespository{

    List<BuyerDTO> buyerDTOS;

    public BuyerRespoitory() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            buyerDTOS = Arrays.asList(mapper.readValue(new ClassPathResource("buyers.json").getFile(), BuyerDTO[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<BuyerDTO> getBuyers()
    {
        return buyerDTOS;
    }

}
