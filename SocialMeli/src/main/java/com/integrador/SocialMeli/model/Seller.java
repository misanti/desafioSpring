package com.integrador.socialmeli.model;

import com.integrador.socialmeli.dto.BuyerWithFollowedDTO;
import com.integrador.socialmeli.dto.PostDTO;

import java.util.ArrayList;

public class Seller {
    private Integer userId;
    private String userName;
    private ArrayList<BuyerWithFollowedDTO> followers; // lista con usuarios que siguen a un determinado vendedor
    private ArrayList<PostDTO> post; // lista de publicaciones que hizo el vendedor
    private Integer followersCount; // cantidad de seguidores que tiene el vendedor

}
