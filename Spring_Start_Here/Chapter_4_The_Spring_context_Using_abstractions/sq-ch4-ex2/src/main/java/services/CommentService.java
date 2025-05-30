package services;

import models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

@Component
public class CommentService {

    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentRepository commentRepository;

    @Autowired
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
