package services;

import models.Comment;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

public class CommentService {

    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository,
                          CommentNotificationProxy commentNotificationProxy){
        this.commentNotificationProxy = commentNotificationProxy;
        this.commentRepository = commentRepository;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
