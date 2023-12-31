package com.domaine.port;

import com.domaine.model.CelestialObject;
import com.domaine.model.Comment;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CelestialObjectService {

    CelestialObject createCelestialObject(String name, String type, Date date);

    List<CelestialObject> getAllCelestialObjects();

    List<CelestialObject> getCelestialObjectsByDate(LocalDateTime dateTime);

    Optional<CelestialObject> getCelestialObjectById(int id);

    CelestialObject updateCelestialObject(int id, CelestialObject celestialObject);

    void deleteCelestialObject(int id);


}
