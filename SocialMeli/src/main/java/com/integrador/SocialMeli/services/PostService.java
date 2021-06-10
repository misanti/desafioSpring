package com.integrador.socialmeli.services;

import com.integrador.socialmeli.dto.BuyerWithFollowedDTO;
import com.integrador.socialmeli.dto.PostByBuyerDTO;
import com.integrador.socialmeli.model.Buyer;
import com.integrador.socialmeli.model.Post;
import com.integrador.socialmeli.repositories.IPostRepository;
import com.integrador.socialmeli.repositories.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    private static final String ORDER_ASC = "date_asc";
    private static final String ORDER_DESC = "date_desc";

    Integer LIMIT_OF_WEEKS = 2;
    @Autowired
    private ISellerService sellerService;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IBuyerService buyerService;

    @Override
    public void newPost(Post post) {
        // Verifico que el seller exista, si no existe, lanzo excepcion
        if (sellerService.obtainSeller(post.getUserId()) == null) {
            throw new RuntimeException("Seller doesn't follow this seller");
        }
        // si existe, guardo los datos de la publicacion
        postRepository.savePost(post);

    }

    @Override
    public PostByBuyerDTO obtainPostBySellers(Integer buyerId, String order) {
        BuyerWithFollowedDTO buyer = buyerService.obtainBuyerWithFollowedById(buyerId);
        List<Post> posts = buyer.getFollowed().stream()
                .flatMap(followed -> postRepository.findAllByUserId(followed.getUserId())
                        .stream())
                .filter(post -> isDateBetweenWeeksLimit(post.getDate()))
                .collect(Collectors.toList());
        if (order != null) {
            this.orderPosts(posts, order);
        }
        return new PostByBuyerDTO(buyer.getUserId(), posts);
    }

    private boolean isDateBetweenWeeksLimit(LocalDate postDate) {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusWeeks(LIMIT_OF_WEEKS);
        return postDate.isAfter(startDate) && postDate.isBefore(endDate);
    }

    public static void orderPosts(List<Post> posts, String order) {
        if (ORDER_ASC.equals(order)) {
            Collections.sort(posts, Comparator.comparing(Post::getDate));
        }
        if (ORDER_DESC.equals(order)) {
            Collections.sort(posts, Comparator.comparing(Post::getDate).reversed());
        }
    }
}
