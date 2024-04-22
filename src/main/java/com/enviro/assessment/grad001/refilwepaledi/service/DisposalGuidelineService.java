package com.enviro.assessment.grad001.refilwepaledi.service;
import com.enviro.assessment.grad001.refilwepaledi.models.DisposalGuideline;

import java.util.List;
public interface DisposalGuidelineService {
    public List<DisposalGuideline> getDisposalGuidelinesByCategoryId(Long categoryId);
    public DisposalGuideline createDisposalGuidelines(Long categoryId, DisposalGuideline guidelines);
    public DisposalGuideline updateDisposalGuidelines(Long categoryId, DisposalGuideline guidelines);
    public void deleteDisposalGuidelines(Long categoryId);

}
