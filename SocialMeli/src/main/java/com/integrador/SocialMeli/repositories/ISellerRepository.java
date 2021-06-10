package com.integrador.socialmeli.repositories;

import com.integrador.socialmeli.dto.SellerDTO;
import com.integrador.socialmeli.dto.SellerWithFollowersDTO;

import java.util.List;

public interface ISellerRepository {

    // Obtiene una lista de todos los vendedores con sus seguidores
    List<SellerWithFollowersDTO> obtainSellersWithFollowers();

    // Obtiene un vendedor con sus seguidores por ID pasado como parametro
    SellerWithFollowersDTO obtainSellerWithFollowersById(Integer userId);

    // Obtiene un vendedor de SellerDTO por ID pasado como parametro
    SellerDTO obtainSellerById(Integer userId);

    // Cambiar instancia de SellerWithFollowersDTO a SellerDTO
    SellerDTO changeInstance(SellerWithFollowersDTO seller);
}
