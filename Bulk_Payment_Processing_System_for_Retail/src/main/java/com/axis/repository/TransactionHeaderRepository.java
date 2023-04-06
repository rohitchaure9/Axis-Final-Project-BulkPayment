package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.TransactionHeader;

@Repository
public interface TransactionHeaderRepository extends JpaRepository<TransactionHeader, Integer>{
	
}
