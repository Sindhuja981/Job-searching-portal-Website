package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.TestResult;

public interface TestResultRepository extends JpaRepository<TestResult, Integer>{
	
	@Query(value = "SELECT test_result_id, vacancy_id, SUM(score) AS score, " +
            "COUNT(selected_option) AS selected_option_count, " +
            "result, " +
            "COUNT(*) AS count " +
            "FROM test_result " +
            "WHERE result IN ('correct', 'incorrect') AND user_id = :userId " +
            "GROUP BY result, vacancy_id", nativeQuery = true)
    List<Object[]> getScoreAndCountByResultAndUserId(@Param("userId") int userId);
}
