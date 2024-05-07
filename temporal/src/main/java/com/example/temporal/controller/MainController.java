package com.example.temporal.controller;


import com.example.temporal.model.DTO.DeviceDTO;
import com.example.temporal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	OrderService orderService;

	@PostMapping("/startWorkflow")
	public String createOrder(@RequestParam("id") String id) {
		orderService.placeOrder(id);
		return "Started Workflow";
	}

	@PostMapping("/signalDeviceDTO")
	public String signalDeviceDTO(@RequestParam("id") String id,@RequestBody DeviceDTO deviceDTO) {
		orderService.receiveDeviceDTO(id,deviceDTO);

		return "Signal sent to workflow";
	}
}
