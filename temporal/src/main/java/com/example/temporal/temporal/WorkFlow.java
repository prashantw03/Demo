package com.example.temporal.temporal;


import com.example.temporal.model.DTO.DeviceDTO;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

//Can only have one WorkFlowMethod and n no. of signalMethod
@WorkflowInterface
public interface WorkFlow {

	public static final String QUEUE_NAME = "Customer_Order";

	@WorkflowMethod
	void startRpdOnboarding();

	@SignalMethod
	void receiveDeviceDTO(DeviceDTO deviceDTO);


}
