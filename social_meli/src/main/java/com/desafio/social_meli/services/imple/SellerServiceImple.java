package com.desafio.social_meli.services.imple;

import com.desafio.social_meli.dtos.SellerWithFollowerCountDTO;
import com.desafio.social_meli.dtos.SellerWithFollowersDTO;
import com.desafio.social_meli.models.Buyer;
import com.desafio.social_meli.models.Seller;
import com.desafio.social_meli.repositories.buyer.IBuyerRepository;
import com.desafio.social_meli.repositories.seller.ISellerRepository;
import com.desafio.social_meli.services.ISellerService;
import com.desafio.social_meli.util.NewInstance;
import com.desafio.social_meli.util.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImple implements ISellerService {

    //region Autowired repositories
    @Autowired
    private IBuyerRepository buyerRepository;
    @Autowired
    private ISellerRepository sellerRepository;

    //endregion Autowired repositories

    //region US0002 - getQuantityFollowersBySellerId
    // Obtengo la cantidad de seguidores que tiene el vendedor que me pasan por parametro
    @Override
    public SellerWithFollowerCountDTO getQuantityFollowersBySellerId(Integer sellerId) {
        Seller seller = sellerRepository.findById(sellerId);
        return new SellerWithFollowerCountDTO(seller.getUserId(), seller.getUserName(), seller.getFollowers().size());
    }

    //endregion US0002 - getQuantityFollowersBySellerId

    //region US0003 - getFollowersBySellerId
    // Obtengo la lista de seguidores que tiene el vendedor que me pasan por parametro
    @Override
    public SellerWithFollowersDTO getFollowersBySellerId(Integer sellerId, String order) {
        Seller seller = sellerRepository.findById(sellerId);

        //region createInstance
        SellerWithFollowersDTO sellerWithFollowers = new SellerWithFollowersDTO();
        sellerWithFollowers.setUserId(seller.getUserId());
        sellerWithFollowers.setUserName(seller.getUserName());
        sellerWithFollowers.setFollowers(seller.getFollowers());
        //endregion createInstance

        if (order != null) {
            Order.orderBuyers(sellerWithFollowers.getFollowers(), order);
        }
        return sellerWithFollowers;
    }

    //endregion US0003 - getFollowersBySellerId



}
