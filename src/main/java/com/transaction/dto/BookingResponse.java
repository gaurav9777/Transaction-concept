package com.transaction.dto;

import com.transaction.entity.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

	private String status;
	private double totalfare;
	private String pnrNo;
	private PassengerInfo passengerInfo;
}
