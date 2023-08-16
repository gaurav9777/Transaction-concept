package com.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String>{

}
