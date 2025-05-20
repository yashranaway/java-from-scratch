package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private boolean completed;
    
    public Task() {}
    
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }
} 