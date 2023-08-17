package com.domaine.service;

import com.domaine.model.Comment;
import com.domaine.port.AppUserService;
import com.domaine.port.CelestialObjectService;
import com.domaine.port.CommentRepository;
import com.domaine.port.CommentService;

import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {


    private AppUserService appUserService;
    private CelestialObjectService celestialObjectService;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(AppUserService appUserService, CelestialObjectService celestialObjectService, CommentRepository commentRepository) {
        this.appUserService = appUserService;
        this.celestialObjectService = celestialObjectService;
        this.commentRepository = commentRepository;
    }

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment saveComment(String content, int appUserId, int celestialObjectId) {
        if(celestialObjectService.getCelestialObjectById(celestialObjectId).isPresent() && appUserService.getUserById(appUserId).isPresent()){
            Comment comment = new Comment(content, celestialObjectService.getCelestialObjectById(celestialObjectId).get(), appUserService.getUserById(appUserId).get());
            commentRepository.save(comment);
        }
        throw new RuntimeException();
    }

    @Override
    public List<Comment> findCelestialObjectComments(int celestialObjectId) {
        return commentRepository.findByCelestialObjectId(celestialObjectId);
    }

    @Override
    public void deleteComment(int id) {
        try {
            Optional<Comment> comment = getCommentById(id);
            commentRepository.delete(comment);
        }catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Optional<Comment> getCommentById(int id) {
        return Optional.ofNullable(commentRepository.findById(id));
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
