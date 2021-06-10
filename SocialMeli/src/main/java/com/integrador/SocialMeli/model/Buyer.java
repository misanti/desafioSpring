package com.integrador.socialmeli.model;


import com.integrador.socialmeli.dto.SellerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {
    private Integer userId;
    private String userName;
    private ArrayList<SellerDTO> followed; // lista con vendedores que sigue a un determinado comprador

}
