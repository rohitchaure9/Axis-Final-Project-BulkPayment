package com.axis.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.model.TemplateDetails;
import com.axis.model.TemplateHeader;
import com.axis.repository.TemplateDetailsRepository;
import com.axis.repository.TemplateHeaderRepository;


@Service
public class TemplateHeaderServiceImpl implements TemplateHeaderService{

	@Autowired
	private TemplateHeaderRepository headerRepository;
	
	@Autowired
	private TemplateDetailsRepository detailsRepository;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public void saveTemplateHeader(TemplateHeader templateHeader) {
	    TemplateHeader tempHeader = new TemplateHeader();
	    tempHeader.setTemplateName(templateHeader.getTemplateName());
	    tempHeader.setCreationDate(LocalDate.now());

	    // set the template header for each template detail object
	    for (TemplateDetails templateDetail : templateHeader.getTemplateDetails()) {
	        templateDetail.setTemplateHeader(tempHeader);
	    }

	    tempHeader.setTemplateDetails(templateHeader.getTemplateDetails());

	    headerRepository.save(tempHeader);
	    detailsRepository.saveAll(tempHeader.getTemplateDetails());
	}

	
	@Override
	public Optional<TemplateHeader> getTemplateHeaderById(int id) {
		// TODO Auto-generated method stub
		Optional<TemplateHeader> templateHeader = headerRepository.findById(id);
		return templateHeader;
	}

	@Override
	public List<TemplateHeader> getAllTemplateHeaders() {
		// TODO Auto-generated method stub
		
		List<TemplateHeader> templateHeaders = headerRepository.findAll();
		
		return templateHeaders;
	}

	@Override
	public String deleteTemplateHeader(int id) { 
		// TODO Auto-generated method stub
		headerRepository.deleteById(id);
		
		return "Header Deleted";
	}
	
	@Override
	public List<TemplateDetails> getTemplateDetailsByTemplateId(int templateId) {
		List<TemplateDetails> templateDetails = new ArrayList<TemplateDetails>();
		EntityTransaction txn = null;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
			txn = entityManager.getTransaction();
    		txn.begin();
    		templateDetails = entityManager.createNativeQuery("SELECT * FROM template_details WHERE template_id="+templateId).getResultList();
    		txn.commit();
		}
		catch ( Throwable e ) {
			if ( txn != null && txn.isActive() ) {
				txn.rollback();
			}
			throw e;
		}
		
		//templateDetails = detailsRepository.findByTemplateId(templateId);
		
		return templateDetails;
		
		
    }

	

}
