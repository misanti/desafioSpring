package com.desafio.social_meli.repositories.seller;

import com.desafio.social_meli.models.Seller;

import java.util.List;

public interface ISellerRepository {
    // Lista de todos los vendedores con sus seguidores
    List<Seller> findSellersWithFollowers();

    // Busca el vendedor por ID
    Seller findById(Integer userId);

}
