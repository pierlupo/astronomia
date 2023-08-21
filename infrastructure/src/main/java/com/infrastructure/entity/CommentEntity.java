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
@Table(name="comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private String content;


    @ManyToOne
    @JoinColumn(name = "celestialObject_id", nullable = false)
    private CelestialObjectEntity celestialObjectEntity;

    @ManyToOne
    @JoinColumn(name = "appuser_id", nullable = false)
    private AppUserEntity appuserEntity;
}
