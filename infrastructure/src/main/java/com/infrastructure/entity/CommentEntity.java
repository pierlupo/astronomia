package com.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private String content;

    @ManyToOne
    private CelestialObjectEntity celestialObjectEntity;

    @ManyToOne
    private AppUserEntity appuserEntity;
}
