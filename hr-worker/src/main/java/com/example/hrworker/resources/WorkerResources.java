package com.example.hrworker.resources;

import com.example.hrworker.dtos.WorkerDTO;
import com.example.hrworker.entities.Worker;
import com.example.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RefreshScope //serve para ele recarregar as configs automaticamente
@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {

    @Value("${test.config}")
    private String testConfig;

    private final Environment env;
    private final WorkerRepository workerRepository;
    private static final Logger logger = LoggerFactory.getLogger(WorkerResources.class);

    public WorkerResources(WorkerRepository workerRepository, Environment env) {
        this.workerRepository = workerRepository;
        this.env = env;
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<WorkerDTO>> findAll() {
        List<WorkerDTO> list = new ArrayList<>();
        workerRepository.findAll().forEach(item -> list.add(new WorkerDTO(item)));
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerDTO> findById(@PathVariable Long id) {
        logger.info("PORT = " + env.getProperty("local.server.port"));
        WorkerDTO dto = new WorkerDTO(workerRepository.findById(id).orElse(new Worker()));
        return ResponseEntity.ok(dto);
    }
}
