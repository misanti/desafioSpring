package com.integrador.socialmeli.services;

import com.integrador.socialmeli.dto.BuyerWithFollowedDTO;
import com.integrador.socialmeli.dto.SellerWithFollowersDTO;
import com.integrador.socialmeli.repositories.IBuyerRespository;
import com.integrador.socialmeli.repositories.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService implements IBuyerService {
    @Autowired
    private IBuyerRespository buyerRespository;
    @Autowired
    private ISellerRepository sellerRepository;

    @Override
    public void followSeller(Integer buyerId, Integer sellerId) {

        // Busco si encuentro el comprador
        BuyerWithFollowedDTO buyer = buyerRespository.getBuyerWithFollowedById(buyerId);

        // Si buyer == null, corto la ejecucion
        if (buyer == null) {
            throw new RuntimeException("Buyer doesn't existe");
        }

        // Si buyer != null, busco el seller
        SellerWithFollowersDTO seller = sellerRepository.getSellerWithFollowersById(sellerId);

        // Si seller == null, corto la ejecucion
        if (seller == null) {
            throw new RuntimeException("Seller doesn't exist");
        }

        // Verifico que el usuario ya no siga al vendedor, si lo sigue, lanzo excepcion
        if ((buyer.getFollowed().contains(sellerId))) {
            throw new RuntimeException("You already follow this seller");
        }

        /* Si no lo sigue, agrego a las listas de vendedores y usuarios para dejar
        constancia del usuario que sigue al vendedor */
        buyer.addFollowed(sellerRepository.changeInstance(seller));
        seller.setFollower(buyerRespository.changeInstance(buyer));

        // TO DO -> Validaciones
    }

    @Override
    public void unfollowSeller(Integer buyerId, Integer sellerId) {

        // Busco si encuentro el comprador
        BuyerWithFollowedDTO buyer = buyerRespository.getBuyerWithFollowedById(buyerId);

        // Si buyer == null, corto la ejecucion
        if (buyer == null) {
            throw new RuntimeException("Buyer doesn't existe");
        }

        // Si buyer != null, busco el seller
        SellerWithFollowersDTO seller = sellerRepository.getSellerWithFollowersById(sellerId);

        // Si seller == null, corto la ejecucion
        if (seller == null) {
            throw new RuntimeException("Seller doesn't exist");
        }

        // Verifico que el usuario siga al vendedor
        if ((buyer.getFollowed().contains(sellerId))) {
             /* Si no lo sigue, agrego a las listas de vendedores y usuarios para dejar
        constancia del usuario que sigue al vendedor */
            buyer.unfollowed(sellerRepository.changeInstance(seller));
            seller.setUnfollower(buyerRespository.changeInstance(buyer));
        }



        // TO DO -> Validaciones
    }


    @Override
    public BuyerWithFollowedDTO getBuyerWithFollowedById(Integer userId) {
        return buyerRespository.getBuyerWithFollowedById(userId);
    }

}
