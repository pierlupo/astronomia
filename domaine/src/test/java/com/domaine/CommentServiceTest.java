package com.domaine;

import com.domaine.model.AppUser;
import com.domaine.model.CelestialObject;
import com.domaine.model.Comment;
import com.domaine.port.CommentRepository;
import com.domaine.port.CommentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CommentServiceTest {

    @Mock
    private final CommentRepository commentRepository;

    @InjectMocks
    private final CommentService commentService;

    public CommentServiceTest(CommentRepository commentRepository, CommentService commentService) {
        this.commentRepository = commentRepository;
        this.commentService = commentService;
    }


//    @ParameterizedTest
//    @ValueSource(strings = { })
    @Test
    public void shouldAddNewCommentWhenValidDataProvided() {
        //Arrange
        CelestialObject c1 = new CelestialObject();
        AppUser appUser1 = new AppUser("toto", "azerty");
        Comment comment = new Comment("c1", c1, appUser1 );
        Mockito.when(commentRepository.save(comment)).thenReturn(comment);

        //Act
        Comment result = commentService.saveComment("c1", 1, 1);

        //Assert
        Assertions.assertEquals(comment, result);
    }

    @Test
    public void shouldReturnCommentByIdWhenExists() {
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
    public void shouldReturnAllCommentsWhenRequested() {
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
    public void shouldDeleteCommentWhenRequested() {
        //Arrange


        //Act


        //Assert
    }
}
