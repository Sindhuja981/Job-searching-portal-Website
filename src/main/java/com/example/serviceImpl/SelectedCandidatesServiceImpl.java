package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Questions;
import com.example.entity.SelectedCandidates;
import com.example.execption.ResourceNotFoundException;
import com.example.repository.SelectedCandidatesRepository;
import com.example.service.SelectedCandidatesService;
@Service
public class SelectedCandidatesServiceImpl implements SelectedCandidatesService{
		@Autowired
		SelectedCandidatesRepository selectedCandiRepo;

		@Override
		public void addSelectedCandidates(SelectedCandidates selectedCandidates) {
			// TODO Auto-generated method stub
			selectedCandiRepo.save(selectedCandidates);
		}

		@Override
		public List<SelectedCandidates> getAllSelectedCandidates() {
			// TODO Auto-generated method stub
			List<SelectedCandidates> list = selectedCandiRepo.findAll();
			return list;
		}

		@Override
		public boolean isSelectedCandidatesExist(int id) {
			// TODO Auto-generated method stub
			Optional<SelectedCandidates> selected = selectedCandiRepo.findById(id);
			SelectedCandidates questionss;
			if(selected.isPresent()) {
				return true;
			}else {
				return false;
			}
		}

		@Override
		public SelectedCandidates getSelectedCandidatesById(int id) {
			// TODO Auto-generated method stub
			Optional<SelectedCandidates> questions = selectedCandiRepo.findById(id);
			SelectedCandidates questionss;
			if(questions.isPresent()) {
				questionss = questions.get();
			}else {
				throw new ResourceNotFoundException("SelectedCandidates","Id", id);
			}
			return questionss;
		}

		@Override
		public boolean deleteSelectedCandidates(int id) {
			// TODO Auto-generated method stub
			Optional<SelectedCandidates> questions = selectedCandiRepo.findById(id);
			SelectedCandidates questionss;
			if(questions.isPresent()) {
				selectedCandiRepo.deleteById(id);
				return true;
			}else {
				return false;
			}
		}

		@Override
		public boolean updateSelectedCandidatesById(SelectedCandidates selectedCandidates) {
			// TODO Auto-generated method stub
			Optional<SelectedCandidates> questions = selectedCandiRepo.findById(selectedCandidates.getId());
			SelectedCandidates questionss;
			if(questions.isPresent()) {
				selectedCandiRepo.save(selectedCandidates);
				return true;
			}else {
			return false;
			}
		}
	
	
	
}
