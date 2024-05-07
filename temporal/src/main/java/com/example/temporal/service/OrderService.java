package com.example.temporal.service;


import com.example.temporal.model.DTO.DeviceDTO;
import com.example.temporal.temporal.WorkFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

@Service
public class OrderService {

	@Autowired
	WorkflowServiceStubs workflowServiceStubs;

	@Autowired
	WorkflowClient workflowClient;

	public void placeOrder(String workflowId) {

		WorkFlow workflow = createWorkFlowConnection(workflowId);
		//to start the workflow
		//startApprovalWorkflow name of WorkflowMethod
		WorkflowClient.start(workflow::startRpdOnboarding);
		System.out.println("here2");
	}
	//call from placeOrder
	public WorkFlow createWorkFlowConnection(String id) {
		//create new workflow Connection.
		//setting task Q
		//setting work flow ID
		WorkflowOptions options = WorkflowOptions.newBuilder().setTaskQueue(WorkFlow.QUEUE_NAME)
				.setWorkflowId("Order_" + id).build();
		return workflowClient.newWorkflowStub(WorkFlow.class, options);
	}

	public void receiveDeviceDTO(String workflowId,DeviceDTO deviceDTO) {
		WorkFlow workflow = workflowClient.newWorkflowStub(WorkFlow.class, "Order_" + workflowId);
		workflow.receiveDeviceDTO(deviceDTO);

	}
}
