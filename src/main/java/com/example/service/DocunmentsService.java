package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Docunments;



@Service
public interface DocunmentsService {
	void addDocuments(Docunments docunments );
	List<Docunments> getAllDocuments();
	boolean isDocumentsExist(int DocumentsId);
	Docunments getDocumentsById(int DocumentsId);
	boolean deleteDocuments(int DocumentsId);
	boolean updateDocumentsId(Docunments docunments);
	
	 List<Docunments> getDocumentsByUserId(int userId);

}
