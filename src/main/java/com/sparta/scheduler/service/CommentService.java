package com.sparta.scheduler.service;

import com.sparta.scheduler.entity.Comment;
import com.sparta.scheduler.entity.Schedule;
import com.sparta.scheduler.repository.CommentRepository;
import com.sparta.scheduler.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository myCommentRepository;
    private ScheduleRepository myScheduleRepository;

    public CommentService(CommentRepository appCommentRepository, ScheduleRepository appScheduleRepository){
        myCommentRepository = appCommentRepository;
        myScheduleRepository = appScheduleRepository;
    }

    // Create comment
    public Comment createComment (Long schedulesId, String content) {
        Schedule schedule = myScheduleRepository.findById(schedulesId).orElseThrow();

        Comment createdComment = new Comment();
        createdComment.setContent(content);
        createdComment.setSchedule(schedule);
        createdComment = myCommentRepository.save(createdComment);
        return createdComment;
    }

    // Get comment
    public Comment getComment (Long commentId) {
        Comment foundComment = myCommentRepository.findById(commentId).orElseThrow();
        return foundComment;
    }

    // Edit comment
    public Comment editComment (Long commentId, String editedContent) {
        Comment editedComment = myCommentRepository.findById(commentId).orElseThrow();
        editedComment.setContent(editedContent);
        editedComment = myCommentRepository.save(editedComment);
        return editedComment;
    }

    // Delete comment
    public boolean deleteComment (Long commentId){
        if (myCommentRepository.existsById(commentId)) {
            myCommentRepository.deleteById(commentId);
            return true;
        } else {
            return false;
        }
    }

}
