package com.enviro.assessment.grad001.refilwepaledi.models;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String guidelines;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Category_Id")
    private WasteCategory wasteCategory;


    public String getGuidelines() {
        return guidelines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGuidelines(String guidelines) {
        this.guidelines = guidelines;
    }


    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

}
