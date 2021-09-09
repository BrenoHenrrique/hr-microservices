package com.example.hrworker.repositories;

import com.example.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query("SELECT w FROM Worker w WHERE w.id = :id")
    Worker findByIdWorker(Long id);
}
