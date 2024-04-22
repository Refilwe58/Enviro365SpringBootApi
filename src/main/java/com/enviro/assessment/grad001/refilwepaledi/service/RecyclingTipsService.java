package com.enviro.assessment.grad001.refilwepaledi.service;

import com.enviro.assessment.grad001.refilwepaledi.models.RecyclingTips;
import com.enviro.assessment.grad001.refilwepaledi.models.WasteCategory;

import java.util.List;

public interface RecyclingTipsService {
    public List<RecyclingTips> getRecyclingTipsByCategoryId(Long categoryId);
    public RecyclingTips createRecyclingTip(Long categoryId, RecyclingTips tip);
    public List<RecyclingTips> getAllRecyclingTips();
    public RecyclingTips updateRecyclingTip(Long tipId, RecyclingTips updatedTip);
    public void deleteRecyclingTip(Long tipId);
    //public RecyclingTips getByCategory(Long id);
}
