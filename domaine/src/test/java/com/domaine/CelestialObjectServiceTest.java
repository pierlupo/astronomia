package com.domaine;

import com.domaine.model.CelestialObject;
import com.domaine.port.CelestialObjectRepository;
import com.domaine.port.CelestialObjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Date;
import java.util.Optional;


public class CelestialObjectServiceTest {

    @Mock
    private final CelestialObjectRepository celestialObjectRepository;

    @InjectMocks
    private final CelestialObjectService celestialObjectService;

//    @BeforeEach
//    void setUp() {
//        celestialObject = new CelestialObject();
//    }

    public CelestialObjectServiceTest(CelestialObjectRepository celestialObjectRepository, CelestialObjectService celestialObjectService) {
        this.celestialObjectRepository = celestialObjectRepository;
        this.celestialObjectService = celestialObjectService;
    }

//    @ParameterizedTest
//    @ValueSource(strings = { "lune", "satellite" })

    @Test
    public void shouldAddNewCelestialObjectWhenValidDataProvided() {
        //Arrange
        CelestialObject celestialObject = new CelestialObject("lune", "satellite");
        Mockito.when(celestialObjectRepository.save(Optional.of(celestialObject))).thenReturn(celestialObject);

        //Act
        CelestialObject result = celestialObjectService.createCelestialObject("lune", "satellite",  new Date());

        //Assert
        Assertions.assertEquals(celestialObject, result);
    }


    @Test
    public void shouldReturnCelestialObjectByIdWhenExists() {
       //Arrange



       //Act


       //Assert

   }

    @Test
    public void shouldRaiseExceptionWhenCelestialObjectByIdNotFound() {
        //Arrange


        //Act


        //Assert
    }

    @Test
    public void shouldReturnAllCelestialObjectsWhenRequested() {
        //Arrange


        //Act


        //Assert
    }

    @Test
    public void shouldReturnCelestialObjectByDateWhenRequested() {
        //Arrange


        //Act


        //Assert
    }

    @Test
    public void shouldDeleteCelestialObjectWhenRequested() {
        //Arrange


        //Act


        //Assert
    }
}
