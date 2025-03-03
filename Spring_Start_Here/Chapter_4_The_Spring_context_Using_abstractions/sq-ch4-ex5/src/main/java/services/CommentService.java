package services;

import models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import proxies.CommentNotificationProxy;
import proxies.CommentPushNotificationProxy;
import repositories.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final CommentNotificationProxy commentNotificationProxy;


    public CommentService(@Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy,
                          CommentRepository commentRepository){
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void pushComment(Comment comment){
        commentNotificationProxy.sendComment(comment);
        commentRepository.storeComment(comment);
    }
}
