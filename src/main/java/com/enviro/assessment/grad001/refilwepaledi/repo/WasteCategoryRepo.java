package com.enviro.assessment.grad001.refilwepaledi.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.enviro.assessment.grad001.refilwepaledi.models.WasteCategory;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface WasteCategoryRepo extends JpaRepository<WasteCategory,Long> {



}
