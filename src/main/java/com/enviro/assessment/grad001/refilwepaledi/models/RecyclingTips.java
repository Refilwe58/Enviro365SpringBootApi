package com.enviro.assessment.grad001.refilwepaledi.models;


import com.enviro.assessment.grad001.refilwepaledi.models.WasteCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class RecyclingTips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "Tip is required")
    private String tip;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Category_Id")
    private WasteCategory wasteCategory;

    public Long getId() {
        return id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public WasteCategory getCategory() {
        return wasteCategory;
    }

    public void setCategory(WasteCategory category) {
        this.wasteCategory = category;
    }
}
