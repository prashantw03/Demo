package com.example.temporal.service;


import com.example.temporal.model.RPD_deviceModel;
import com.example.temporal.model.ScannerModel;
import com.example.temporal.repo.RPD_deviceModelRepo;
import com.example.temporal.repo.ScannerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RPD_deviceService {

    @Autowired
    RPD_deviceModelRepo rpdDeviceRepo;

    @Autowired
    ScannerRepo scannerRepo;

    public void addDevice(RPD_deviceModel obj) throws Exception {
        {
            Optional<RPD_deviceModel> user = rpdDeviceRepo.findByMac(obj.getName());
            if (user.isPresent()) {
                throw new Exception("Device already exists with this Name");
            }
            rpdDeviceRepo.save(obj);
        }
    }

    public RPD_deviceModel getDevice(String mac) throws Exception {
        Optional<RPD_deviceModel> user = rpdDeviceRepo.findByMac(mac);
        System.out.println(mac);
        if (!user.isPresent()) {
            throw new Exception("Device with this mac does not exist");
        }

        return user.get();
    }
    public boolean mobileScanner(long siteId,String mac) {
        System.out.println("In Mobile Scanner");
        //check if mac id is present and return
        try {
            RPD_deviceModel rpdDeviceModel = getDevice(mac);
            //save to a new table(id,lat,lon,mac?)
            //ScannerModel scannerModel=new ScannerModel(siteId,mac);
            //scannerRepo.save(scannerModel);

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            //when device not present with given mac
            return false;
        }
        System.out.println("id and mac saved");
        return true;
    }

    public void addScannerDetail(ScannerModel obj){
        {
            scannerRepo.save(obj);
        }
    }



}
