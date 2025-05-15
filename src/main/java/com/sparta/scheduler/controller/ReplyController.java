package com.sparta.scheduler.controller;

import com.sparta.scheduler.entity.Reply;
import com.sparta.scheduler.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReplyController {

    private ReplyService myReplyService;

    public ReplyController(ReplyService appReplyService) {
        myReplyService = appReplyService;
    }

    // id == comment's id
    @PostMapping("/comments/{id}/replies")
    public ResponseEntity<Reply> createReply(@PathVariable Long id, @RequestBody String content) {
        Reply createdReply = myReplyService.createReply(id, content);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReply);
    }

    @GetMapping("/replies/{id}")
    public ResponseEntity<Reply> getReply(@PathVariable Long id) {
        Reply foundReply = myReplyService.getReply(id);
        return ResponseEntity.status(HttpStatus.OK).body(foundReply);
    }

    @PutMapping("/replies/{id}")
    public ResponseEntity<Reply> editReply(@PathVariable Long id, @RequestBody String content){
        Reply editedReply = myReplyService.editReply(id, content);
        return ResponseEntity.status(HttpStatus.OK).body(editedReply);
    }

    @DeleteMapping("/replies/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable Long id) {
        if(myReplyService.deleteReply(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
