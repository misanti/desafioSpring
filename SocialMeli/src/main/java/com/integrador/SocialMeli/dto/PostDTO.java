package com.integrador.socialmeli.dto;

import java.util.ArrayList;
import java.util.Date;

public class PostDTO {
    private Integer userIdSeller;
    private Integer idPost;
    private Date date;
    private ArrayList<ProductDTO> productList;
    private Integer category;
    private double price;
}
