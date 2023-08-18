package com.domaine.port;

import com.domaine.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Comment save(Comment comment);

//    List<Comment> findByCelestialObjectId(int celestialObjectId);
    void delete(Optional<Comment> comment);
    Comment findById(int id);
    List<Comment> findAll();
}
