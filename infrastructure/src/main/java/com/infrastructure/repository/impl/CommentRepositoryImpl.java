package com.infrastructure.repository.impl;


import com.domaine.model.CelestialObject;
import com.domaine.model.Comment;
import com.domaine.port.CommentRepository;
import com.infrastructure.entity.CelestialObjectEntity;
import com.infrastructure.entity.CommentEntity;
import com.infrastructure.repository.CommentEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private final ModelMapper modelMapper;
    private final CommentEntityRepository commentEntityRepository;

    public CommentRepositoryImpl(ModelMapper modelMapper, CommentEntityRepository commentEntityRepository) {
        this.modelMapper = modelMapper;
        this.commentEntityRepository = commentEntityRepository;
    }


    @Override
    public Comment save(Comment comment) {
        CommentEntity commentEntity = modelMapper.map(comment, CommentEntity.class);
        commentEntity = commentEntityRepository.save(commentEntity);
        return modelMapper.map(commentEntity, Comment.class);
    }

    @Override
    public List<Comment> findByCelestialObject(int id) {
        List<CommentEntity> commentEntities = commentEntityRepository.findByCelestialObjectEntity(id);
        return commentEntities.stream()
                .map(entity -> modelMapper.map(entity, Comment.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Optional<Comment> comment) {
        commentEntityRepository.delete(modelMapper.map(comment, CommentEntity.class));
    }

    @Override
    public Comment findById(int id) {
        return modelMapper.map(
                commentEntityRepository.findById(id), Comment.class
        );
    }

    @Override
    public List<Comment> findAll() {
        return convertToListComments((List<CommentEntity>) commentEntityRepository.findAll());
    }

    private List<Comment> convertToListComments(List<CommentEntity> commentEntities) {
        List<Comment> comments = new ArrayList<>();
        commentEntities.forEach(c ->comments.add(modelMapper.map(c, Comment.class)));
        return comments;
    }
}
