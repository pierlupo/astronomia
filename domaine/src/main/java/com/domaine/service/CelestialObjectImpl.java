package com.domaine.service;

import com.domaine.model.CelestialObject;
import com.domaine.model.Comment;
import com.domaine.port.CelestialObjectRepository;
import com.domaine.port.CelestialObjectService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CelestialObjectImpl implements CelestialObjectService {

    private final CelestialObjectRepository celestialObjectRepository;

    public CelestialObjectImpl(CelestialObjectRepository celestialObjectRepository) {
        this.celestialObjectRepository = celestialObjectRepository;
    }

    @Override
    public CelestialObject createCelestialObject(String name, String type, LocalDateTime date, List<Comment> comments) {
        CelestialObject celestialObject = new CelestialObject(name, type, LocalDateTime.now());
        return celestialObjectRepository.save(Optional.of(celestialObject));
    }


    @Override
    public List<CelestialObject> getAllCelestialObjects() {
        return celestialObjectRepository.findAll();
    }

    @Override
    public List<CelestialObject> getCelestialObjectsByDate(LocalDateTime dateTime) {
        return celestialObjectRepository.findAllByDate(dateTime);
    }

    @Override
    public Optional<CelestialObject> getCelestialObjectById(int id) {
        return Optional.ofNullable(celestialObjectRepository.findById(id));
    }

    @Override
    public CelestialObject updateCelestialObject(int id, CelestialObject celestialObject) {
        return null;
    }

//    @Override
//    public CelestialObject updateCelestialObject(int id, CelestialObject celestialObject) {
//        try {
//            Optional<CelestialObject> oldCelestialObject= getCelestialObjectById(id);
//            oldCelestialObject.setName(celestialObject.getName());
//            oldCelestialObject.setType(celestialObject.getType());
//            oldCelestialObject.setDate(celestialObject.getDate());
//            return celestialObjectRepository.save(oldCelestialObject);
//        }catch (Exception ex) {
//            throw new RuntimeException(ex.getMessage());
//        }
//    }

    @Override
    public void deleteCelestialObject(int id) {
        try {
            Optional<CelestialObject> celestialObject = getCelestialObjectById(id);
            celestialObjectRepository.delete(celestialObject);
        }catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
