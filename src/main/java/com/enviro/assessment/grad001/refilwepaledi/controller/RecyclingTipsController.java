package com.enviro.assessment.grad001.refilwepaledi.controller;

import com.enviro.assessment.grad001.refilwepaledi.models.RecyclingTips;
import com.enviro.assessment.grad001.refilwepaledi.models.WasteCategory;
import com.enviro.assessment.grad001.refilwepaledi.service.RecyclingTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Map;

import java.util.List;
import java.util.Optional;
import java.util.HashMap;



@RestController
@RequestMapping("/recycle_tip")
@Validated
public class RecyclingTipsController {
    @Autowired
    private RecyclingTipsService recyclingTipsService;

    @GetMapping
    public ResponseEntity<List<?>> getAllWasteCategories() {
        List<RecyclingTips> recyclingTips = recyclingTipsService.getAllRecyclingTips();
        List<Map<String, Object>> tipDetails = new ArrayList<>();
        if (!recyclingTips.isEmpty()) {
            for (RecyclingTips tip : recyclingTips) {
                Map<String, Object> tipMap = new HashMap<>();
                tipMap.put("id", tip.getId());
                tipMap.put("tip", tip.getTip());
                tipMap.put("categoryId", tip.getCategory().getId());
                // Add more properties as needed

                tipDetails.add(tipMap);
            }
            return ResponseEntity.ok(tipDetails);
        }else {
            System.out.println("not found");
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?>getRecyclingTipsByCategoryId(@PathVariable("categoryId") Long categoryId) {
        List<RecyclingTips> tips = recyclingTipsService.getRecyclingTipsByCategoryId(categoryId);

        List<Map<String, Object>> tipDetails = new ArrayList<>();
        if (!tips.isEmpty()) {
            for (RecyclingTips tip : tips) {
                Map<String, Object> tipMap = new HashMap<>();
                tipMap.put("id", tip.getId());
                tipMap.put("tip", tip.getTip());
                tipMap.put("categoryId", tip.getCategory().getId());
                // Add more properties as needed

                tipDetails.add(tipMap);
            }
            return ResponseEntity.ok(tipDetails);
        } else {
            System.out.println("not found");
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/{categoryId}")
    public ResponseEntity<RecyclingTips> createRecyclingTip(@PathVariable("categoryId") Long categoryId, @RequestBody RecyclingTips tip) {
        RecyclingTips createdTip = recyclingTipsService.createRecyclingTip(categoryId, tip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTip);
    }

    @PutMapping("/{tipId}")
    public ResponseEntity<?> updateRecyclingTip( @PathVariable("tipId") Long tipId,@RequestBody RecyclingTips tip)
    {
        RecyclingTips updatedRecyclingTips = recyclingTipsService.updateRecyclingTip(tipId, tip);
        if (updatedRecyclingTips != null) {
            System.out.println(updatedRecyclingTips);
            return ResponseEntity.ok("successfully updated");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{tipId}")
    public ResponseEntity<Void> deleteRecyclingTip( @PathVariable("tipId") Long tipId) {
        recyclingTipsService.deleteRecyclingTip(tipId);
        return ResponseEntity.noContent().build();
    }

}
