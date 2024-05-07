package com.example.temporal.temporal;

import com.example.temporal.model.DTO.DeviceDTO;
import com.example.temporal.model.RPD_deviceModel;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface Activity {
	@ActivityMethod
	String rpdOnboarding();

	@ActivityMethod
	String preProvisioning(DeviceDTO deviceDTO);

	@ActivityMethod
	String discovery();

	@ActivityMethod
	String onboarding();
}
