package com.transaction.service;

import java.util.UUID;

import javax.naming.InsufficientResourcesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.dto.BookingRequest;
import com.transaction.dto.BookingResponse;
import com.transaction.entity.PassengerInfo;
import com.transaction.entity.PaymentInfo;
import com.transaction.repo.PassengerInfoRepository;
import com.transaction.repo.PaymentInfoRepository;
import com.transaction.util.PaymentUtils;

@Service
public class FlightBookingService {

	 @Autowired
	    private PassengerInfoRepository passengerInfoRepository;
	    @Autowired
	    private PaymentInfoRepository paymentInfoRepository;

	    @Transactional//(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	    public BookingResponse bookFlightTicket(BookingRequest request) {

	        PassengerInfo passengerInfo = request.getPassengerInfo();
	        passengerInfo = passengerInfoRepository.save(passengerInfo);

	        PaymentInfo paymentInfo = request.getPaymentInfo();

	        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

	        paymentInfo.setPassengerId(passengerInfo.getPId());
	        paymentInfo.setAmount(passengerInfo.getFare());
	        paymentInfoRepository.save(paymentInfo);
	        return new BookingResponse("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
	}
}
