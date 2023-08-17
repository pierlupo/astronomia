package com.domaine;

import com.domaine.port.CelestialObjectRepository;
import com.domaine.port.CelestialObjectService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class CelestialObjectServiceTest {

    @Mock
    private CelestialObjectRepository celestialObjectRepository;

    @InjectMocks
    private CelestialObjectService celestialObjectService;


//   @Test
//    public void shouldAddNewCelestialObjectWhenValidDataProvided() {
//        //Arrange
//        CelestialObject celestialObject = new CelestialObject("lune", "satellite", 2023-08-17 , "c1" );
//        Mockito.when(celestialObjectRepository.save(Optional.of(celestialObject))).thenReturn(celestialObject);
//
//        //Act
//        CelestialObject result = celestialObjectService.createCelestialObject("lune", "satellite", 2023-08-17, "c1"  );
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
