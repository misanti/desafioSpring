package com.integrador.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.integrador.socialmeli.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer userId; // id del vendedor
    private Integer idPost;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private Integer category;
    private double price;
}
