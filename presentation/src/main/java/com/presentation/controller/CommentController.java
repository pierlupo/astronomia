package com.presentation.controller;


import com.domaine.model.Comment;
import com.domaine.port.CommentService;
import com.presentation.dto.CommentRequestDTO;
import com.presentation.dto.CommentResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/comment")
@RestController
public class CommentController {

    private final CommentService commentService;

    private final ModelMapper modelMapper;

    public CommentController(CommentService commentService, ModelMapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<CommentResponseDTO> post(@RequestBody CommentRequestDTO commentRequestDTO) {
        return ResponseEntity.ok(
                modelMapper.map(
                        commentService.saveComment(
                                commentRequestDTO.getContent(),
                                commentRequestDTO.getCelestialObject().getId(),
                                commentRequestDTO.getAppuser().getId()),
                        CommentResponseDTO.class)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<CommentResponseDTO>> get() {
        return ResponseEntity.ok(convertToListComments(commentService.getAllComments()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(int id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok("Comment deleted");
    }

    private List<CommentResponseDTO> convertToListComments(List<Comment> comments) {
        List<CommentResponseDTO> commentResponseDTOS = new ArrayList<>();
        comments.forEach(c ->commentResponseDTOS.add(modelMapper.map(c, CommentResponseDTO.class)));
        return commentResponseDTOS;
    }
}
