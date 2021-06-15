package com.desafio.social_meli.services.imple;

import com.desafio.social_meli.dtos.BuyerDTO;
import com.desafio.social_meli.dtos.SellerDTO;
import com.desafio.social_meli.dtos.SellerWithFollowersDTO;
import com.desafio.social_meli.exceptions.UserNotFoundException;
import com.desafio.social_meli.models.Buyer;
import com.desafio.social_meli.models.Seller;
import com.desafio.social_meli.repositories.buyer.IBuyerRepository;
import com.desafio.social_meli.repositories.seller.ISellerRepository;
import com.desafio.social_meli.services.IBuyerService;
import com.desafio.social_meli.util.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImple implements IBuyerService {

    //region Autowired repositories
    @Autowired
    private IBuyerRepository buyerRepository;
    @Autowired
    private ISellerRepository sellerRepository;
    //endregion Autowired repositories

    //region US0001 - followSeller
    @Override
    public void followSeller(Integer buyerId, Integer sellerId) {
        // Busco primero si encuentro al comprador y luego busco al vendedor

        Buyer buyer = buyerRepository.findById(buyerId);
        Seller seller = sellerRepository.findById(sellerId);
        //Verifico que el comprador no siga al vendedor
        if ((buyer.getFollowed()
                .stream()
                .anyMatch(seller1 -> seller1.getUserId() == sellerId))) {
            throw new UserNotFoundException("Ya sigues a este vendedor");
        }

        //region createInstances
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setUserId(seller.getUserId());
        sellerDTO.setUserName(seller.getUserName());
        BuyerDTO buyerDTO = new BuyerDTO();
        buyerDTO.setUserId(buyer.getUserId());
        buyerDTO.setUserName(buyer.getUserName());
        //endregion createInstances

        // Agrego a sus respectivas listas.
        buyer.followSeller(sellerDTO);
        seller.addFollowers(buyerDTO);
    }
    //endregion US0001 - followSeller

    //region US0004 - getBuyerWithFollowedById
    @Override
    public Buyer getBuyerWithFollowedById(Integer userId, String order) {
        Buyer buyer = buyerRepository.findById(userId);

        if (order != null) {
            Order.orderSellers(buyer.getFollowed(), order);
        }
        return buyer;
    }
    //endregion US0004 - getBuyerWithFollowedById

    //region US0007 - unfollowSeller
    @Override
    public void unfollowSeller(Integer buyerId, Integer sellerId) {
        Buyer buyer = buyerRepository.findById(buyerId);
        Seller seller = sellerRepository.findById(sellerId);

        //region createInstances
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setUserId(seller.getUserId());
        sellerDTO.setUserName(seller.getUserName());
        BuyerDTO buyerDTO = new BuyerDTO();
        buyerDTO.setUserId(buyer.getUserId());
        buyerDTO.setUserName(buyer.getUserName());
        //endregion createInstances

        seller.removeBuyer(buyerDTO);
        buyer.unfollowSeller(sellerDTO);
    }
    //endregion US0007 - unfollowSeller

}
