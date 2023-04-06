package com.axis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axis.model.TemplateDetails;
import com.axis.model.TemplateHeader;


@Repository
public interface TemplateDetailsRepository extends JpaRepository<TemplateDetails, Integer> {
	//List<TemplateDetails> findByTemplateId(int templateId);
}
