package com.integrador.socialmeli.services;

import com.integrador.socialmeli.dto.BuyerDTO;
import com.integrador.socialmeli.dto.BuyerWithFollowedDTO;
import com.integrador.socialmeli.dto.SellerDTO;
import com.integrador.socialmeli.dto.SellerWithFollowersDTO;
import com.integrador.socialmeli.repositories.IBuyerRespository;
import com.integrador.socialmeli.repositories.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class BuyerService implements IBuyerService {

    private static final String ORDER_ASC = "name_asc";
    private static final String ORDER_DESC = "name_desc";

    @Autowired
    private IBuyerRespository buyerRespository;
    @Autowired
    private ISellerRepository sellerRepository;

    @Override
    public void followSeller(Integer buyerId, Integer sellerId) {

        // Busco si encuentro el comprador
        BuyerWithFollowedDTO buyer = buyerRespository.obtainBuyerWithFollowedById(buyerId);

        // Si buyer == null, corto la ejecucion
        if (buyer == null) {
            throw new RuntimeException("Buyer doesn't existe");
        }

        // Si buyer != null, busco el seller
        SellerWithFollowersDTO seller = sellerRepository.obtainSellerWithFollowersById(sellerId);

        // Si seller == null, corto la ejecucion
        if (seller == null) {
            throw new RuntimeException("Seller doesn't exist");
        }

        // Verifico que el usuario ya no siga al vendedor, si lo sigue, lanzo excepcion
        if ((buyer.getFollowed().stream().anyMatch(sellerDTO -> sellerDTO.getUserId() == sellerId))) {
            throw new RuntimeException("You already follow this seller");
        }

        /* Si no lo sigue, agrego a las listas de vendedores y usuarios para dejar
        constancia del usuario que sigue al vendedor */
        buyer.addFollowed(sellerRepository.changeInstance(seller));
        seller.addFollow(buyerRespository.changeInstance(buyer));

        // TO DO -> Validaciones
    }

    @Override
    public void unfollowSeller(Integer buyerId, Integer sellerId) {

        // Busco si encuentro el comprador
        BuyerWithFollowedDTO buyer = buyerRespository.obtainBuyerWithFollowedById(buyerId);

        // Si buyer == null, corto la ejecucion
        if (buyer == null) {
            throw new RuntimeException("Buyer doesn't existe");
        }

        // Si buyer != null, busco el seller
        SellerWithFollowersDTO seller = sellerRepository.obtainSellerWithFollowersById(sellerId);

        // Si seller == null, corto la ejecucion
        if (seller == null) {
            throw new RuntimeException("Seller doesn't exist");
        }

        // Verifico que el usuario ya siga al vendedor, si lo sigue, lanzo excepcion
        if (!(buyer.getFollowed().stream().anyMatch(sellerDTO -> sellerDTO.getUserId() == sellerId))) {
            throw new RuntimeException("Buyer doesn't follow this seller");
        }
        // Si no lo sigue, lo sigo y agrego en las listas correspondientes
        seller.unfollowBuyer(buyerRespository.changeInstance(buyer));
        buyer.unfollowSeller(sellerRepository.changeInstance(seller));

    }


    @Override
    public BuyerWithFollowedDTO obtainBuyerWithFollowedById(Integer userId, String order) {
        BuyerWithFollowedDTO buyer = buyerRespository.obtainBuyerWithFollowedById(userId);
        if (order != null) {
            this.orderSellers(buyer.getFollowed(), order);
        }
        return buyer;
    }

    @Override
    public BuyerWithFollowedDTO obtainBuyerWithFollowedById(Integer userId) {
        return buyerRespository.obtainBuyerWithFollowedById(userId);
    }

    private void orderSellers(List<SellerDTO> sellers, String order) {
        if (ORDER_DESC.equals(order)) {
            Collections.sort(sellers, Comparator.comparing(SellerDTO::getUserName).reversed());
        }
        if (ORDER_ASC.equals(order)) {
            Collections.sort(sellers, Comparator.comparing(SellerDTO::getUserName));
        }
    }

}
