package com.integrador.socialmeli.controller;

import com.integrador.socialmeli.dto.BuyerWithFollowedDTO;
import com.integrador.socialmeli.dto.PostByBuyerDTO;
import com.integrador.socialmeli.dto.SellerDTO;
import com.integrador.socialmeli.dto.SellerWithFollowersDTO;
import com.integrador.socialmeli.model.Post;
import com.integrador.socialmeli.services.IBuyerService;
import com.integrador.socialmeli.services.IPostService;
import com.integrador.socialmeli.services.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialMeliController {

    // Buyers
    @Autowired
    private IBuyerService iBuyerService;
    @Autowired
    private ISellerService iSellerService;
    @Autowired
    private IPostService iPostService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    // No devolver Entity almacenadas
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

    @GetMapping("/users/{UserID}/followed/list")
    public ResponseEntity<BuyerWithFollowedDTO> getFollowersbyBuyerCode(@PathVariable Integer UserID, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(iBuyerService.obtainBuyerWithFollowedById(UserID, order));
    }

    @GetMapping("/products/followed/{userId}/list")
    public PostByBuyerDTO getPostsByBuyer(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return iPostService.obtainPostBySellers(userId, order);

    }

    // Sellers

    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<SellerDTO> getSeller(@PathVariable Integer userId) {
        return ResponseEntity.ok(iSellerService.obtainSeller(userId));
    }

    @GetMapping("/users/{UserID}/followers/list/")
    public ResponseEntity<SellerWithFollowersDTO> getFollowersbySellerCode(@PathVariable Integer UserID, @RequestParam(required = false) String order) {

        return ResponseEntity.ok(iSellerService.obtainFollowersBySellerId(UserID, order));
    }

    @PostMapping("/products/newpost")
    public ResponseEntity<HttpStatus> newPost(@RequestBody Post post) {
        try {
            iPostService.newPost(post);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }


}
