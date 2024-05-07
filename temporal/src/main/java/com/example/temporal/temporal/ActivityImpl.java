package com.example.temporal.temporal;
import com.example.temporal.model.DTO.DeviceDTO;
import com.example.temporal.model.RPD_deviceModel;
import com.example.temporal.model.ScannerModel;
import com.example.temporal.repo.RPD_deviceModelRepo;
import com.example.temporal.service.RPD_deviceService;
import org.springframework.beans.factory.annotation.Autowired;


public class ActivityImpl implements Activity {

	@Autowired
	RPD_deviceModelRepo rpdDeviceModelRepo;

	@Autowired
	RPD_deviceService rpd_deviceService;

	@Override
	public String rpdOnboarding() {
		// Logic for RpdOnboarding
		return "RpdOnboarding completed";
	}

	@Override
	public String preProvisioning(DeviceDTO deviceDTO) {
		RPD_deviceModel obj=new RPD_deviceModel(deviceDTO.getName(),deviceDTO.getMacAddress(),deviceDTO.getSerialNumber(),deviceDTO.getManufacturer(),deviceDTO.getModel());

		try {
			rpd_deviceService.getDevice(obj.getMac());
			System.out.println("Device with this mac already exist");
		} catch (Exception e) {

			rpdDeviceModelRepo.save(obj);
			System.out.println("Device Data Saved");
		}

		return "PreProvisioning completed";
	}

	@Override
	public String discovery() {

		String mac="00:00:00:00:00:01"; // Temp
		try{
			RPD_deviceModel rpdDeviceObj =rpd_deviceService.getDevice(mac);


			long lat=65;           // Temp
			long lon=104;           // Temp
			long siteId=10001;  // Temp
			if(rpd_deviceService.mobileScanner(siteId,rpdDeviceObj.getMac())){
				ScannerModel scannerModel=new ScannerModel(siteId,lat,lon,mac);
				rpd_deviceService.addScannerDetail(scannerModel);
				System.out.println("discovered RPDs updated");
			}
		}catch(Exception e){
			System.out.println("Failed error:"+e.getMessage());
		}
		return "discovery completed";
	}

	@Override
	public String onboarding() {
		// Logic for Onboarding
		return "Onboarding completed";
	}
}

