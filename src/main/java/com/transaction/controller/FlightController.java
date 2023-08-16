package com.transaction.controller;

import javax.naming.InsufficientResourcesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.dto.BookingRequest;
import com.transaction.dto.BookingResponse;
import com.transaction.service.FlightBookingService;

@RestController
@RequestMapping("/v1/ticket")
public class FlightController {

	@Autowired
	private FlightBookingService bookingService;
	
	@PostMapping("/booking")
	public BookingResponse bookFlightTicket(@RequestBody BookingRequest  bookingRequest) throws InsufficientResourcesException {
		return bookingService.bookFlightTicket(bookingRequest);
	}
}
