package com.domaine;

import com.domaine.model.CelestialObject;
import com.domaine.port.CelestialObjectRepository;
import com.domaine.port.CelestialObjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;


public class CelestialObjectServiceTest {

    @Mock
    private CelestialObjectRepository celestialObjectRepository;

    @InjectMocks
    private CelestialObjectService celestialObjectService;

//   @Test
//    public void shouldAddNewCelestialObjectWhenValidDataProvided() {
//        //Arrange
//       CelestialObject celestialObject = new CelestialObject("lune", "satellite", new Date());
//        Mockito.when(celestialObjectRepository.save(Optional.of(celestialObject))).thenReturn(celestialObject);
//
//        //Act
//        CelestialObject result = celestialObjectService.createCelestialObject("lune", "satellite",  new Date());
//
//        //Assert
//        Assertions.assertEquals(celestialObject, result);
//    }


    @Test
    public void shouldReturnCelestialObjectByIdWhenExists() {

    }

    @Test
    public void shouldRaiseExceptionWhenCelestialObjectByIdNotFound() {

    }
}
