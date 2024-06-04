package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Company;
import com.example.entity.Docunments;
import com.example.entity.JobApply;
import com.example.execption.ResourceNotFoundException;
import com.example.repository.DocunmentRepository;
import com.example.service.DocunmentsService;

@Service
public class DocunmentServiceImpl implements DocunmentsService{
	@Autowired
	DocunmentRepository DocunmentsRepos;
	
	
	@Override
	public void addDocuments(Docunments docunments) {
		// TODO Auto-generated method stub
		DocunmentsRepos.save(docunments);
	}

	@Override
	public List<Docunments> getAllDocuments() {
		// TODO Auto-generated method stub
		List<Docunments> list = DocunmentsRepos.findAll();
		return list;
		
	}

	@Override
	public boolean isDocumentsExist(int DocumentsId) {
		// TODO Auto-generated method stub
		Optional<Docunments> docum = DocunmentsRepos.findById(DocumentsId);
		Docunments documents;
		if(docum.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Docunments getDocumentsById(int DocumentsId) {
		// TODO Auto-generated method stub
		Optional<Docunments> Company = DocunmentsRepos.findById(DocumentsId);
		Docunments Companys;
		if(Company.isPresent()) {
			Companys = Company.get();
		}else {
			throw new ResourceNotFoundException("Docunments","DocumentsId", DocumentsId);
		}
		return Companys;
	}

	@Override
	public boolean deleteDocuments(int DocumentsId) {
		// TODO Auto-generated method stub
		Optional<Docunments> Company = DocunmentsRepos.findById(DocumentsId);
		Docunments Companys;
		if(Company.isPresent()) {
			DocunmentsRepos.deleteById(DocumentsId);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateDocumentsId(Docunments docunments) {
		// TODO Auto-generated method stub
		Optional<Docunments> Companys = DocunmentsRepos.findById(docunments.getDocumentsId());
		Docunments Companyes;
		if(Companys.isPresent()) {
			Companyes=DocunmentsRepos.save(docunments);
			return true;
		}else {
		return false;
		}
	}

	@Override
	public List<Docunments> getDocumentsByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Docunments> doclist=DocunmentsRepos.findByJobsekersUserId(userId);
		return doclist;
	}
	

}
