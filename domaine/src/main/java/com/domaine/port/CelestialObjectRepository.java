package com.domaine.port;

import com.domaine.model.CelestialObject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CelestialObjectRepository {

    CelestialObject save(Optional<CelestialObject> celestialObject);

    CelestialObject findById(int id);

    List<CelestialObject> findAll();

    List<CelestialObject> findAllByDate(LocalDateTime date);

    void delete(Optional<CelestialObject> celestialObject);

}
