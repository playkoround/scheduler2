package com.sparta.scheduler.service;

import com.sparta.scheduler.entity.Comment;
import com.sparta.scheduler.entity.Reply;
import com.sparta.scheduler.repository.CommentRepository;
import com.sparta.scheduler.repository.ReplyRepository;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
    private ReplyRepository myReplyRepository;
    private CommentRepository myCommentRepository;

    public ReplyService(ReplyRepository appReplyRepository, CommentRepository appCommentRepository) {
        myReplyRepository = appReplyRepository;
        myCommentRepository = appCommentRepository;
    }

    // Create reply
    public Reply createReply(Long commentId, String content) {
        Comment comment = myCommentRepository.findById(commentId).orElseThrow();
        Reply createdreply = new Reply();
        createdreply.setComment(comment);
        createdreply.setContent(content);
        createdreply = myReplyRepository.save(createdreply);
        return createdreply;
    }

    // Get reply
    public Reply getReply(Long id){
        Reply foundReply = myReplyRepository.findById(id).orElseThrow();
        return foundReply;
    }

    // Edit reply
    public Reply editReply(Long id, String content) {
        Reply editedReply = myReplyRepository.findById(id).orElseThrow();
        editedReply.setContent(content);
        editedReply = myReplyRepository.save(editedReply);
        return editedReply;
    }

    public boolean deleteReply(Long id){
        if(myReplyRepository.existsById(id)) {
            myReplyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
