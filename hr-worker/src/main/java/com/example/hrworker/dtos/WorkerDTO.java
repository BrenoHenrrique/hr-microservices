package com.example.hrworker.dtos;

import com.example.hrworker.entities.Worker;

import java.io.Serializable;

public class WorkerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double dailyIncome;

    public WorkerDTO() {
    }

    public WorkerDTO(Long id, String name, Double dailyIncome) {
        super();
        this.id = id;
        this.name = name;
        this.dailyIncome = dailyIncome;
    }

    public WorkerDTO(Worker entity) {
        super();
        id = entity.getId();
        name = entity.getName();
        dailyIncome = entity.getDailyIncome();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }
}
