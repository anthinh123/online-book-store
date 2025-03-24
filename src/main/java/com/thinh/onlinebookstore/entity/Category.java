package com.thinh.onlinebookstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is required")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    private String name;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;
}