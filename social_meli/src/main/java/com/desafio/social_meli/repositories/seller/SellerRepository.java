package com.desafio.social_meli.repositories.seller;

import com.desafio.social_meli.exceptions.UserNotFoundException;
import com.desafio.social_meli.models.Seller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class SellerRepository implements ISellerRepository {

    private List<Seller> seller;

    public SellerRepository() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            seller = Arrays.asList(mapper.readValue(new ClassPathResource("sellers.json").getFile(), Seller[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Seller> findSellersWithFollowers() {
        return seller;
    }

    /* Obtiene el vendedor por ID, sino lanza una excepcion indicando que
    el vendedor no existe
  */
    @Override
    public Seller findById(Integer userId) {
        return seller.stream()
                .filter(seller1 -> seller1.getUserId() == userId)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("El vendedor con el id " + userId + " no existe"));
    }

}
