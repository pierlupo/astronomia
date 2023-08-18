package com.domaine;

import com.domaine.model.AppUser;
import com.domaine.port.AppUserRepository;
import com.domaine.port.AppUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


public class AppUserServiceTest {

    @Mock
    private final AppUserRepository appUserRepository;

    @InjectMocks
    private final AppUserService appUserService;

    public AppUserServiceTest(AppUserRepository appUserRepository, AppUserService appUserService) {
        this.appUserRepository = appUserRepository;
        this.appUserService = appUserService;
    }

    @ParameterizedTest
    @ValueSource(strings = { "toto", "azerty" })
    public void shouldAddNewAppUserWhenValidDataProvided() {
        //Arrange
        AppUser appUser = new AppUser("toto", "azerty");
        Mockito.when(appUserRepository.save(appUser)).thenReturn(appUser);

        //Act
        AppUser result = appUserService.createUser("toto", "azerty");

        //Assert
        Assertions.assertEquals(appUser, result);
    }

    @Test
    public void shouldReturnAppUserByIdWhenExists() {
        //Arrange



        //Act


        //Assert

    }

    @Test
    public void shouldRaiseExceptionWhenAppUserIdNotFound() {
        //Arrange


        //Act


        //Assert
    }

    @Test
    public void shouldReturnUsernameAndPasswordWhenRequested() {
        //Arrange


        //Act


        //Assert
    }

    @Test
    public void shouldReturnUserByUserNameWhenRequested() {
        //Arrange


        //Act


        //Assert
    }

    @Test
    public void shouldDeleteAppUserWhenRequested() {
        //Arrange


        //Act


        //Assert
    }
}
