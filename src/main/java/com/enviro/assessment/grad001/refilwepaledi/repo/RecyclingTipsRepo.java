package com.enviro.assessment.grad001.refilwepaledi.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.enviro.assessment.grad001.refilwepaledi.models.RecyclingTips;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecyclingTipsRepo extends  JpaRepository<RecyclingTips,Long> {

    List<RecyclingTips> findByWasteCategory_Id(Long CategoryId);
}
