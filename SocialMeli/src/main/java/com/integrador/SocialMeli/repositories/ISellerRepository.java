package com.integrador.SocialMeli.repositories;

import com.integrador.SocialMeli.dto.SellerDTO;

import java.util.List;

public interface ISellerRepository {
    // Obtiene todos los vendedores
    List<SellerDTO> getSellers();

    // Obtiene los vendedores por codigo de vendedor - ID
    SellerDTO getSellerById(Integer userId);

    // Obtener seguidores por codigo de vendedor - ID
    SellerDTO getFollowersBySellerId(Integer userId);

}
