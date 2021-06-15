package com.desafio.social_meli.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SellerWithFollowerCountDTO {
    private Integer userId;
    private String userName;
    private Integer followers_count;
}
