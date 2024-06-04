package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.Docunments;
import com.example.service.DocunmentsService;

@RestController
@RequestMapping("/api/v1")
public class DocunmentController {
	@Autowired
	DocunmentsService DocunmentsSerive;
	
	@PostMapping(value="/Adddocunments")
	public ResponseEntity<Object> addDocunment(@RequestBody Docunments docunments ){
		DocunmentsSerive.addDocuments(docunments);
		return new ResponseEntity<>("docunments added successfully", HttpStatus.CREATED);
	}
	@GetMapping(value="/alldocunments")
	public ResponseEntity<Object> getAllDocunment(){
		List<Docunments> docunments = DocunmentsSerive.getAllDocuments();
		ResponseEntity<Object> entity = new ResponseEntity<>(docunments, HttpStatus.OK);
		return entity;
		
	}
	@DeleteMapping(value = "/deleteDocunment/{DocumentsId}")
	public ResponseEntity<Object> deleteDocunment(@PathVariable("DocumentsId") int DocumentsId){
		boolean flag;
		if(DocunmentsSerive.deleteDocuments(DocumentsId)) {
			flag = DocunmentsSerive.deleteDocuments(DocumentsId);
		}else {
			flag = false;
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);
		
	}
	@GetMapping(value = "/getdocunment/{DocumentsId}")
    public ResponseEntity<Object> getDocunmentyById(@PathVariable("DocumentsId") int DocumentsId) {
        Docunments docunment = DocunmentsSerive.getDocumentsById(DocumentsId);
        if (docunment != null) {
            return new ResponseEntity<>(docunment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("docunment not found", HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping(value="/updatedocunment/{DocumentsId}")
	public ResponseEntity<Object> updateDocunmentId(@PathVariable("DocumentsId") int DocumentsId, @RequestBody Docunments docunment)
	{
		boolean flag;
		if(DocunmentsSerive.isDocumentsExist(DocumentsId)) {
			flag = DocunmentsSerive.updateDocumentsId(docunment);
		}else {
			flag = false;
		}		
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
	@GetMapping("/getDocuments/{userId}")
	public ResponseEntity<Object> getMethodName(@PathVariable("userId")int userId) {
		
			List<Docunments> company = DocunmentsSerive.getDocumentsByUserId(userId);
			ResponseEntity<Object> entity = new ResponseEntity<>(company, HttpStatus.OK);

			return entity;
		}

}
