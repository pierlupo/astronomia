package com.presentation.controller;


import com.domaine.model.CelestialObject;
import com.domaine.port.CelestialObjectService;
import com.presentation.dto.CelestialObjectRequestDTO;
import com.presentation.dto.CelestialObjectResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/celestialobject")
@RestController
public class CelestialObjectController {

    private final CelestialObjectService celestialObjectService;
    private final ModelMapper modelMapper;

    public CelestialObjectController(CelestialObjectService celestialObjectService, ModelMapper modelMapper) {
        this.celestialObjectService = celestialObjectService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<CelestialObjectResponseDTO> post(@RequestBody CelestialObjectRequestDTO celestialObjectRequestDTO) {
        return ResponseEntity.ok(
                modelMapper.map(
                        celestialObjectService.createCelestialObject(
                                celestialObjectRequestDTO.getName(),
                                celestialObjectRequestDTO.getType(),
                                celestialObjectRequestDTO.getDate()),
                        CelestialObjectResponseDTO.class)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<CelestialObjectResponseDTO>> get() {
        return ResponseEntity.ok(convertToListCelestialObjects(celestialObjectService.getAllCelestialObjects()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CelestialObjectResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(modelMapper.map(celestialObjectService.getCelestialObjectById(id), CelestialObjectResponseDTO.class));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<CelestialObjectResponseDTO>> getByDate(@PathVariable LocalDateTime date) {
        return ResponseEntity.ok(convertToListCelestialObjects(celestialObjectService.getCelestialObjectsByDate(date)));
    }


    @PutMapping("/{id}")
    public ResponseEntity<CelestialObjectResponseDTO> put(@PathVariable int id, @RequestBody CelestialObjectRequestDTO celestialObjectRequestDTO) {
        return  ResponseEntity.ok(
                modelMapper.map(
                        celestialObjectService.updateCelestialObject(id, modelMapper.map(celestialObjectRequestDTO, CelestialObject.class)),
                        CelestialObjectResponseDTO.class)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(int id) {
        celestialObjectService.deleteCelestialObject(id);
        return ResponseEntity.ok("CelestialObject deleted");
    }


    private List<CelestialObjectResponseDTO> convertToListCelestialObjects(List<CelestialObject> celestialObjects) {
        List<CelestialObjectResponseDTO> celestialObjectResponseDTOS = new ArrayList<>();
        celestialObjects.forEach(c ->celestialObjectResponseDTOS.add(modelMapper.map(c, CelestialObjectResponseDTO.class)));
        return celestialObjectResponseDTOS;
    }
}
