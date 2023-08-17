package com.presentation.dto;


import com.domaine.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CelestialObjectResponseDTO {

    private int id;

    private String name;

    private String type;

    private Date date;

    private List<Comment> comments;
}
