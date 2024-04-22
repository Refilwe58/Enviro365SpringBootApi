package com.enviro.assessment.grad001.refilwepaledi.controller;
import com.enviro.assessment.grad001.refilwepaledi.models.DisposalGuideline;
import com.enviro.assessment.grad001.refilwepaledi.models.RecyclingTips;
import com.enviro.assessment.grad001.refilwepaledi.service.DisposalGuidelineService;
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
@RequestMapping("/disposal_guideline")
@Validated
public class DisposalGuidelineController {
    @Autowired
    private DisposalGuidelineService disposalGuidelineService;

    @GetMapping("/{categoryId}")
    public ResponseEntity<?>getRecyclingTipsByCategoryId(@PathVariable("categoryId") Long categoryId) {
        List<DisposalGuideline> tips = disposalGuidelineService.getDisposalGuidelinesByCategoryId(categoryId);

        List<Map<String, Object>> tipDetails = new ArrayList<>();
        if (!tips.isEmpty()) {
            for (DisposalGuideline tip : tips) {
                Map<String, Object> tipMap = new HashMap<>();
                tipMap.put("id", tip.getId());
                tipMap.put("Guidelines", tip.getGuidelines());
                tipMap.put("categoryId", tip.getWasteCategory().getId());
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
    public ResponseEntity<DisposalGuideline> createRecyclingTip(@PathVariable("categoryId") Long categoryId, @RequestBody DisposalGuideline guideline) {
        DisposalGuideline createdGuideline = disposalGuidelineService.createDisposalGuidelines(categoryId, guideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGuideline);
    }

    @PutMapping("/{guidelineId}")
    public ResponseEntity<?> updateRecyclingTip( @PathVariable("guidelineId") Long guidelineId,@RequestBody DisposalGuideline guideline)
    {
        DisposalGuideline updatedDisposalGuideline = disposalGuidelineService.updateDisposalGuidelines(guidelineId, guideline);
        if (updatedDisposalGuideline != null) {
            System.out.println(updatedDisposalGuideline);
            return ResponseEntity.ok("successfully updated");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{guidelineId}")
    public ResponseEntity<Void> deleteRecyclingTip( @PathVariable("guidelineId") Long guidelineId) {
        disposalGuidelineService.deleteDisposalGuidelines(guidelineId);
        return ResponseEntity.noContent().build();
    }
}
