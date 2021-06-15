package com.desafio.social_meli.repositories.buyer;

import com.desafio.social_meli.models.Buyer;

public interface IBuyerRepository {

    // Busca el comprador por ID
    Buyer findById(Integer userId);

}
