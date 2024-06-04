package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.SelectedCandidates;

public interface SelectedCandidatesRepository extends JpaRepository<SelectedCandidates, Integer>{

}
