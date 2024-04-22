package com.enviro.assessment.grad001.refilwepaledi.service;

import java.util.List;
import com.enviro.assessment.grad001.refilwepaledi.models.WasteCategory;
import jakarta.persistence.*;


public interface WasteCategoryService {
    public WasteCategory saveCategory(WasteCategory category);
    public List<WasteCategory> getAllCategories();
    public WasteCategory updateCategory(Long id,WasteCategory category);
    public WasteCategory getCategory(Long id);
    public void deleteCategory(Long id);


}
