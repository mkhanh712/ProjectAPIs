package com.main.DTO;

import java.util.List;
import lombok.*;

import com.main.entity.VariantProduct;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VariantProductDTO {
	private long productId;
	private String productName;
	private List<VariantProduct> variants;
}
