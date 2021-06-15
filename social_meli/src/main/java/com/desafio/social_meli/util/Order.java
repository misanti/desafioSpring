package com.desafio.social_meli.util;

import com.desafio.social_meli.dtos.BuyerDTO;
import com.desafio.social_meli.dtos.SellerDTO;
import com.desafio.social_meli.dtos.SellerWithFollowerCountDTO;
import com.desafio.social_meli.models.Buyer;
import com.desafio.social_meli.models.Seller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Order {
    private static final String ORDER_ASC = "name_asc";
    private static final String ORDER_DESC = "name_desc";

    public static void orderBuyers(ArrayList<BuyerDTO> buyers, String order) {

        if (ORDER_DESC.equals(order)) {
            Collections.sort(buyers, Comparator.comparing(BuyerDTO::getUserName).reversed());
        }
        if (ORDER_ASC.equals(order)) {
            Collections.sort(buyers, Comparator.comparing(BuyerDTO::getUserName));
        }
    }

    public static void orderSellers(ArrayList<SellerDTO> sellers, String order) {
        if (ORDER_DESC.equals(order)) {
            Collections.sort(sellers, Comparator.comparing(SellerDTO::getUserName).reversed());
        }
        if (ORDER_ASC.equals(order)) {
            Collections.sort(sellers, Comparator.comparing(SellerDTO::getUserName));
        }
    }
}
