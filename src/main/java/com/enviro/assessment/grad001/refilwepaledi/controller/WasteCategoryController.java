package com.enviro.assessment.grad001.refilwepaledi.controller;

import com.enviro.assessment.grad001.refilwepaledi.models.WasteCategory;
import com.enviro.assessment.grad001.refilwepaledi.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/waste_category")
@Validated
public class WasteCategoryController {
    @Autowired
    private WasteCategoryService wasteCategoryService;

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        List<WasteCategory> wasteCategories = wasteCategoryService.getAllCategories();
        return ResponseEntity.ok(wasteCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable("id") Long id) {
        WasteCategory wasteCategory = wasteCategoryService.getCategory(id);
        if (wasteCategory != null) {
            return ResponseEntity.ok(wasteCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@RequestBody WasteCategory category) {
        WasteCategory createdCategory = wasteCategoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable("id") Long id, @RequestBody WasteCategory category) {
        WasteCategory updatedCategory = wasteCategoryService.updateCategory(id, category);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable("id") Long id) {
        wasteCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }



}
