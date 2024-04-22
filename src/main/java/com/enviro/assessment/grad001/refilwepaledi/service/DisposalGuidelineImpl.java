package com.enviro.assessment.grad001.refilwepaledi.service;
import com.enviro.assessment.grad001.refilwepaledi.models.DisposalGuideline;
import com.enviro.assessment.grad001.refilwepaledi.models.RecyclingTips;
import com.enviro.assessment.grad001.refilwepaledi.models.WasteCategory;
import com.enviro.assessment.grad001.refilwepaledi.repo.DisposalGuidelineRepo;
import com.enviro.assessment.grad001.refilwepaledi.repo.WasteCategoryRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DisposalGuidelineImpl implements DisposalGuidelineService {
    @Autowired
    private DisposalGuidelineRepo disposalGuidelineRepo;
    @Autowired
    private WasteCategoryRepo wasteCategoryRepo;

    @Override
    public List<DisposalGuideline> getDisposalGuidelinesByCategoryId(Long categoryId) {

        return disposalGuidelineRepo.findByWasteCategory_Id(categoryId);
    }

    @Override
    public DisposalGuideline createDisposalGuidelines(Long categoryId, DisposalGuideline guidelines) {
        WasteCategory wasteCategory =wasteCategoryRepo.findById(categoryId).orElse(null);
        if(wasteCategory!=null){
            guidelines.setWasteCategory(wasteCategory);
            return disposalGuidelineRepo.save(guidelines);
        }
        return null;

    }

    @Override
    public DisposalGuideline updateDisposalGuidelines(Long guidelineId, DisposalGuideline guidelines) {
        Optional <DisposalGuideline> tempDisposalGuideline=disposalGuidelineRepo.findById(guidelineId);
        if(tempDisposalGuideline.isPresent()){
            DisposalGuideline updateDisposalGuideline=tempDisposalGuideline.get();
            updateDisposalGuideline.setGuidelines(guidelines.getGuidelines());
            return disposalGuidelineRepo.save(updateDisposalGuideline);
        }else{
            throw new IllegalArgumentException("Disposal Guideline id "+guidelineId+" not found");
        }
    }

    @Override
    public void deleteDisposalGuidelines(Long guidelineId) {
        disposalGuidelineRepo.deleteById(guidelineId);
    }
}
