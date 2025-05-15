package com.sparta.scheduler.controller;

import com.sparta.scheduler.entity.Comment;
import com.sparta.scheduler.entity.Schedule;
import com.sparta.scheduler.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private CommentService myCommentService;

    public CommentController(CommentService appCommentService) {
        myCommentService = appCommentService;
    }

    // id == schedule's id
    @PostMapping("/schedules/{id}/comments")
    public ResponseEntity<Comment> createComment(@PathVariable Long id, @RequestBody String content){
        Comment createdComment = myCommentService.createComment(id, content);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    // ?? 댓글 id가 있으면 어차피 일정 id도 알게 되니까 필요 없을 것 같은데, url을 이렇게 작성해도 되는가?
    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id){
        Comment foundComment = myCommentService.getComment(id);
        return ResponseEntity.status(HttpStatus.OK).body(foundComment);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> editComment (@PathVariable Long id, @RequestBody String content) {
        Comment editedComment = myCommentService.editComment(id, content);
        return ResponseEntity.status(HttpStatus.OK).body(editedComment);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteComment (@PathVariable Long id) {
        if (myCommentService.deleteComment(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
