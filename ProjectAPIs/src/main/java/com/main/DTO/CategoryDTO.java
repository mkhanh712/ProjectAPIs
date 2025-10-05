package com.main.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
	private long id;
	private String name;
	private String description;
}
