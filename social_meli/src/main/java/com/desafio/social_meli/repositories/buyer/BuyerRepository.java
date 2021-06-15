package com.desafio.social_meli.repositories.buyer;


import com.desafio.social_meli.exceptions.UserNotFoundException;
import com.desafio.social_meli.models.Buyer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class BuyerRepository implements IBuyerRepository {

    List<Buyer> buyer;


    public BuyerRepository() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            buyer = Arrays.asList(mapper.readValue(new ClassPathResource("buyers.json").getFile(), Buyer[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* Obtiene el comprador por ID, sino lanza una excepcion indicando que
      el comprador no existe
    */

    @Override
    public Buyer findById(Integer userId) {
        return buyer.stream()
                .filter(buyerId -> buyerId.getUserId() == userId)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("El comprador con el id " + userId + " no existe"));

    }
}
