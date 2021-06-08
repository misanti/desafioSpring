package com.integrador.SocialMeli.services;

import com.integrador.SocialMeli.dto.BuyerDTO;
import com.integrador.SocialMeli.dto.SellerDTO;
import com.integrador.SocialMeli.repositories.IBuyerRespository;
import com.integrador.SocialMeli.repositories.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService implements IBuyerService {
    @Autowired
    private IBuyerRespository buyerRespository;
    @Autowired
    private ISellerRepository sellerRepository;

    @Override
    public BuyerDTO followSeller(Integer buyerId, Integer sellerId) {

        // Busco si encuentro el comprador
        BuyerDTO buyer = this.serachBuyerById(buyerId);

        // Si buyer == null, corto la ejecucion
        if (buyer == null) {
            throw new RuntimeException("Buyer doesn't existe");
        }

        // Si buyer != null, busco el seller
        SellerDTO seller = this.searchSellerById(sellerId);

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
        buyer.setFollowedById(seller.getUserId());
        seller.setFollower(buyer.getUserId());

        return buyer;
        // TO DO -> Validaciones
        //
    }


    private BuyerDTO serachBuyerById(Integer buyerId) {
        BuyerDTO buyer = buyerRespository.getBuyers().stream()
                .filter(user -> user.getUserId() == buyerId)
                .findFirst().get();

        return buyer;
    }

    private SellerDTO searchSellerById(Integer sellerId) {

        SellerDTO seller = sellerRepository.getSellers()
                .stream()
                .filter(seller1 -> seller1.getUserId() == sellerId)
                .findFirst()
                .get();

        return seller;
    }


}
