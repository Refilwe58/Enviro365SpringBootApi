package com.enviro.assessment.grad001.refilwepaledi.service;

import com.enviro.assessment.grad001.refilwepaledi.models.DisposalGuideline;
import com.enviro.assessment.grad001.refilwepaledi.repo.DisposalGuidelineRepo;
import com.enviro.assessment.grad001.refilwepaledi.repo.RecyclingTipsRepo;
import com.enviro.assessment.grad001.refilwepaledi.repo.WasteCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.enviro.assessment.grad001.refilwepaledi.models.WasteCategory;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryImp implements WasteCategoryService {
    @Autowired
    private WasteCategoryRepo wasteCategoryRepository;

    @Override
    public WasteCategory saveCategory(@Valid WasteCategory category) {
        return wasteCategoryRepository.save(category);

    }

    @Override
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }

    @Override
    public WasteCategory updateCategory(Long id,@Valid WasteCategory category) {
        Optional <WasteCategory> tempCategory=wasteCategoryRepository.findById(id);
        if(tempCategory.isPresent()){
            WasteCategory updateCategory=tempCategory.get();
            updateCategory.setCategory(category.getCategory());
            return wasteCategoryRepository.save(updateCategory);
        }else{
            throw new IllegalArgumentException("Category id "+id+" not found");
        }
    }

    @Override
    public WasteCategory getCategory(Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Category not found"));
    }

    @Override
    public void deleteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);

    }


}
