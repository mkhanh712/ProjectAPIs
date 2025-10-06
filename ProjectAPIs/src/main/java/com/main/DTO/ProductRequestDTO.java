package com.main.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    private String name;
    private String description;
    private Long categoryId;
}
