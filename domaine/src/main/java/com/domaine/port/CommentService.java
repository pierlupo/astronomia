package com.domaine.port;

import com.domaine.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Comment saveComment(String content, int appUserId, int celestialObjectID);

    List<Comment> findCelestialObjectComments(int celestialObjectID);

    void deleteComment(int id);

    Optional<Comment> getCommentById(int id);

    List<Comment> getAllComments();
}
