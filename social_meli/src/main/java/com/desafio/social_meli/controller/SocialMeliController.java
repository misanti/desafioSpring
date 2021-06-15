package com.desafio.social_meli.controller;

import com.desafio.social_meli.dtos.SellerWithFollowerCountDTO;
import com.desafio.social_meli.dtos.SellerWithFollowersDTO;
import com.desafio.social_meli.models.Buyer;
import com.desafio.social_meli.services.IBuyerService;
import com.desafio.social_meli.services.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocialMeliController {

    // region autowierd
    @Autowired
    private IBuyerService buyerService;
    @Autowired
    private ISellerService sellerService;

    // endregion autowierd

    //region  US0001
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public void followSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        buyerService.followSeller(userId, userIdToFollow);
    }

    //endregion US0001

    //region  US0002

    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<SellerWithFollowerCountDTO> getSeller(@PathVariable Integer userId) {
        return ResponseEntity.ok(sellerService.getQuantityFollowersBySellerId(userId));
    }

    //endregion US0002

    //region US0003 y US0008
    @GetMapping("/users/{UserID}/followers/list/")
    public ResponseEntity<SellerWithFollowersDTO> getFollowersbySellerId(@PathVariable Integer UserID, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(sellerService.getFollowersBySellerId(UserID, order));
    }
    //endregion US003

    //region US0004 y US008
    @GetMapping("/users/{UserID}/followed/list")
    public ResponseEntity<Buyer> getFollowersbyBuyerCode(@PathVariable Integer UserID, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(buyerService.getBuyerWithFollowedById(UserID, order));
    }
    //endregion US0004 y US008

    //region US0005

    //endregion US0005
    
    //region US0007
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public void unfollowSeller(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        buyerService.unfollowSeller(userId, userIdToUnfollow);
    }


    //endregion US0007

}
