package com.integrador.socialmeli.controller;

import com.integrador.socialmeli.dto.BuyerWithFollowedDTO;
import com.integrador.socialmeli.dto.SellerDTO;
import com.integrador.socialmeli.dto.SellerWithFollowersDTO;
import com.integrador.socialmeli.services.IBuyerService;
import com.integrador.socialmeli.services.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialMeliController {

    // Buyers
    @Autowired
    private IBuyerService iBuyerService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<HttpStatus> followSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {

        try {
            iBuyerService.followSeller(userId, userIdToFollow);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<HttpStatus> unfollowSeller(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {

        try {
            iBuyerService.unfollowSeller(userId, userIdToUnfollow);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }

    // Sellers
    @Autowired
    private ISellerService iSellerService;

    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<SellerDTO> getSeller(@PathVariable Integer userId) {
        return ResponseEntity.ok(iSellerService.getSeller(userId));
    }

    @GetMapping("/users/{UserID}/followers/list/")
    public ResponseEntity<SellerWithFollowersDTO> getFollowersbySellerCode(@PathVariable Integer UserID) {
        return ResponseEntity.ok(iSellerService.getFollowersBySellerId(UserID));
    }

    @GetMapping("/users/{UserID}/followed/list")
    public ResponseEntity<BuyerWithFollowedDTO> getFollowersbyBuyerCode(@PathVariable Integer UserID) {
        return ResponseEntity.ok(iBuyerService.getBuyerWithFollowedById(UserID));
    }


}
