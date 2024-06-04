package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.entity.SelectedCandidates;
@Service
public interface SelectedCandidatesService {
	
	void addSelectedCandidates(SelectedCandidates selectedCandidates);
	
	List<SelectedCandidates> getAllSelectedCandidates();
	boolean isSelectedCandidatesExist(int id);
	SelectedCandidates getSelectedCandidatesById(int id);
	boolean deleteSelectedCandidates(int id);
	boolean updateSelectedCandidatesById(SelectedCandidates selectedCandidates);

}
