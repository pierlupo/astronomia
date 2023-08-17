package com.presentation.dto;


import com.domaine.model.AppUser;
import com.domaine.model.CelestialObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDTO {

    private int id;

    private String content;

    private CelestialObject celestialObject;

    private AppUser appuser;
}
