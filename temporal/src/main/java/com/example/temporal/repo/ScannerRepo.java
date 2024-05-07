package com.example.temporal.repo;

import com.example.temporal.model.ScannerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScannerRepo extends JpaRepository<ScannerModel, Integer> {

}
