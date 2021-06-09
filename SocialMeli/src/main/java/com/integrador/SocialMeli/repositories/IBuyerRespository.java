package com.integrador.socialmeli.repositories;

import com.integrador.socialmeli.dto.BuyerDTO;
import com.integrador.socialmeli.dto.BuyerWithFollowedDTO;

import java.util.List;


public interface IBuyerRespository {
    // Obtiene una lista de todos los compradores y a quienes sigue
    List<BuyerWithFollowedDTO> getBuyerWithFollowed();

    // Obtiene un comprador y a quienes sigue con  ID pasado como parametro
    BuyerWithFollowedDTO getBuyerWithFollowedById(Integer userId);

    // Cambiar instancia de BuyerWithFollowersDTO a BuyerDTO
    public BuyerDTO changeInstance(BuyerWithFollowedDTO buyer);

}
