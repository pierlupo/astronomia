package com.infrastructure.repository.impl;

import com.domaine.model.CelestialObject;
import com.domaine.port.CelestialObjectRepository;
import com.infrastructure.entity.CelestialObjectEntity;
import com.infrastructure.repository.CelestialObjectEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class CelestialObjectRepositoryImpl implements CelestialObjectRepository {

    private final CelestialObjectEntityRepository celestiaObjectEntityRepository;
    private final ModelMapper modelMapper;

    public CelestialObjectRepositoryImpl(CelestialObjectEntityRepository celestiaObjectEntityRepository, ModelMapper modelMapper) {
        this.celestiaObjectEntityRepository = celestiaObjectEntityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CelestialObject save(Optional<CelestialObject> celestialObject) {
        CelestialObjectEntity celestialObjectEntity = modelMapper.map(celestialObject, CelestialObjectEntity.class);
        return modelMapper.map(celestiaObjectEntityRepository.save(celestialObjectEntity), CelestialObject.class);
    }

    @Override
    public CelestialObject findById(int id) {
        Optional<CelestialObjectEntity> optionalReportEntity = celestiaObjectEntityRepository.findById(id);
        if(optionalReportEntity.isPresent()){
            return modelMapper.map(optionalReportEntity.get(), CelestialObject.class);
        }
        throw new RuntimeException();
    }

    @Override
    public List<CelestialObject> findAll() {
        return convertToListCelestialObjects((List<CelestialObjectEntity>) celestiaObjectEntityRepository.findAll());
    }

    @Override
    public List<CelestialObject> findAllByDate(LocalDateTime date) {
        return convertToListCelestialObjects(celestiaObjectEntityRepository.findAllByDate(date));
    }

    @Override
    public void delete(Optional<CelestialObject> celestialObject) {
        celestiaObjectEntityRepository.delete(modelMapper.map(celestialObject, CelestialObjectEntity.class));
    }

    private List<CelestialObject> convertToListCelestialObjects(List<CelestialObjectEntity> celestialObjectEntities) {
        List<CelestialObject> celestialObjects = new ArrayList<>();
        celestialObjectEntities.forEach(c ->celestialObjects.add(modelMapper.map(c, CelestialObject.class)));
        return celestialObjects;
    }
}
