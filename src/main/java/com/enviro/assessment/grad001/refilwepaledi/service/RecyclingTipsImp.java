package com.enviro.assessment.grad001.refilwepaledi.service;
import jakarta.validation.Valid;
import com.enviro.assessment.grad001.refilwepaledi.models.RecyclingTips;
import com.enviro.assessment.grad001.refilwepaledi.models.WasteCategory;
import com.enviro.assessment.grad001.refilwepaledi.repo.RecyclingTipsRepo;
import com.enviro.assessment.grad001.refilwepaledi.repo.WasteCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class RecyclingTipsImp implements RecyclingTipsService {
    @Autowired
    private RecyclingTipsRepo recyclingTipsRepo;

    @Autowired
    private WasteCategoryRepo wasteCategoryRepo;

    @Override
    public List<RecyclingTips> getRecyclingTipsByCategoryId(Long categoryId) {
        return recyclingTipsRepo.findByWasteCategory_Id(categoryId);
    }
    @Override
    public List<RecyclingTips> getAllRecyclingTips() {
        return recyclingTipsRepo.findAll();
    }

    @Override
    public RecyclingTips createRecyclingTip(Long categoryId, RecyclingTips tip) {
        WasteCategory wasteCategory=wasteCategoryRepo.findById(categoryId).orElse(null);
        if (wasteCategory != null) {
            tip.setCategory(wasteCategory);
            return recyclingTipsRepo.save(tip);

        }
        return null;
    }

    @Override
    public RecyclingTips updateRecyclingTip( Long tipId,@Valid RecyclingTips updatedTip) {
        Optional <RecyclingTips> tempRecyclingTips=recyclingTipsRepo.findById(tipId);
        if(tempRecyclingTips.isPresent()){
            RecyclingTips updateCategory=tempRecyclingTips.get();
            updateCategory.setTip(updatedTip.getTip());
            return recyclingTipsRepo.save(updateCategory);
        }else{
            throw new IllegalArgumentException("RecyclingTip id "+tipId+" not found");
        }
    }

    @Override
    public void deleteRecyclingTip( Long tipId) {

        recyclingTipsRepo.deleteById(tipId);
    }
}
