package com.example.temporal.repo;

import com.example.temporal.model.RPD_deviceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RPD_deviceModelRepo extends JpaRepository<RPD_deviceModel,Integer> {
public Optional<RPD_deviceModel> findByMac(String mac);
}
