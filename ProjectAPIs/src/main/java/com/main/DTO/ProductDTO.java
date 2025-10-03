package com.main.DTO;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String categoryName;

    public ProductDTO(Long id, String name, String description, String categoryName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryName = categoryName;
    }
}
