package com.main.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	private String description;
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VariantProduct> variants;
	
//	 public Long getId() { return id; }
//	    public void setId(Long id) { this.id = id; }
//
//	    public String getName() { return name; }
//	    public void setName(String name) { this.name = name; }
//
//	    public String getDescription() { return description; }
//	    public void setDescription(String description) { this.description = description; }
//
//	    public Category getCategory() { return category; }
//	    public void setCategory(Category category) { this.category = category; }
}
