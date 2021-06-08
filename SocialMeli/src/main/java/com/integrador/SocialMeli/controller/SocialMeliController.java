package com.integrador.SocialMeli.controller;

import com.integrador.SocialMeli.dto.SellerDTO;
import com.integrador.SocialMeli.services.IBuyerService;
import com.integrador.SocialMeli.services.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialMeliController {

    // Buyers
    @Autowired
    private IBuyerService iBuyerService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<HttpStatus> followSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow)
    {
        iBuyerService.followSeller(userId,userIdToFollow);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // Sellers
    @Autowired
    private ISellerService iSellerService;

    @PostMapping("/users/{userId}/followers/count/")
    public ResponseEntity<SellerDTO> getSeller(@PathVariable Integer userId)
    {
        return ResponseEntity.ok(iSellerService.getSeller(userId));
    }

    @PostMapping("/users/{UserID}/followers/list/")
    public ResponseEntity<SellerDTO> getFollowersbySellerCode(@PathVariable Integer UserID)
    {
        return ResponseEntity.ok(iSellerService.getFollowersBySellerId(UserID));
    }

}
