package com.enviro.assessment.grad001.refilwepaledi.models;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "waste_category_id", unique = true)
    private Long id;

    @Column
    @NotBlank(message = "Category is required")
    private String category;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

}
