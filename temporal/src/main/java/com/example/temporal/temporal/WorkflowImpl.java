package com.example.temporal.temporal;

import com.example.temporal.model.DTO.DeviceDTO;
import com.example.temporal.model.RPD_deviceModel;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;
import java.util.Map;

public class WorkflowImpl implements WorkFlow {

	//
	private final RetryOptions retryoptions = RetryOptions.newBuilder().setInitialInterval(Duration.ofSeconds(1))
			.setMaximumInterval(Duration.ofSeconds(100)).setBackoffCoefficient(2).setMaximumAttempts(50000).build();
	private final ActivityOptions options = ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(30))
			.setRetryOptions(retryoptions).build();
	//
	private final Activity activity = Workflow.newActivityStub(Activity.class, options);
	private boolean receivedDeviceDTO=false;
	private DeviceDTO deviceDTO;

	@Override
	public void startRpdOnboarding() {
		System.out.println("inWorkFlow");

		activity.rpdOnboarding();
		//signalUserData
		//signalPreProvisioning
		//signalDiscovery
		//signalOnboarding
		//Workflow.await(() -> will wait till the signal method is triggered

		System.out.println("***** Waiting for User Data");


		Workflow.await(()->receivedDeviceDTO);
		System.out.println("***** Waiting for Pre Provisioning");
		activity.preProvisioning(deviceDTO);

		System.out.println("***** Discover State");
		activity.discovery();

		System.out.println("***** On boarding State");
		activity.onboarding();

	}

	@Override
	public void receiveDeviceDTO(DeviceDTO deviceDTO) {
		this.deviceDTO = deviceDTO;
		this.receivedDeviceDTO = true;
	}


}
