package com.enviro.assessment.grad001.refilwepaledi.repo;
import com.enviro.assessment.grad001.refilwepaledi.models.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisposalGuidelineRepo extends JpaRepository<DisposalGuideline,Long>{

    List<DisposalGuideline> findByWasteCategory_Id(Long categoryId);
}
