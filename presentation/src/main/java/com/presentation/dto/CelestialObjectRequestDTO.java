package com.presentation.dto;


import com.domaine.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CelestialObjectRequestDTO {

    private String name;

    private String type;

    private LocalDateTime date;

    private List<Comment> comments;
}
