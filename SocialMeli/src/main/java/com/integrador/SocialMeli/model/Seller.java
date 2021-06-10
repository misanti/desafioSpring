package com.integrador.socialmeli.model;

import com.integrador.socialmeli.dto.BuyerWithFollowedDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    private Integer userId;
    private String userName;
    private ArrayList<BuyerWithFollowedDTO> followers; // lista con usuarios que siguen a un determinado vendedor
    private ArrayList<Post> post; // lista de publicaciones que hizo el vendedor
    private Integer followersCount; // cantidad de seguidores que tiene el vendedor

}
