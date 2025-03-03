package main;

import models.Comment;
import proxies.EmailCommentNotificationProxy;
import repositories.CommentRepository;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {

    public static void main(String[] args){
        var dbCommentRepository = new DBCommentRepository();
        var emailCommentNotificationProxy = new EmailCommentNotificationProxy();

        var commentService = new CommentService(dbCommentRepository, emailCommentNotificationProxy);

        var comment = new Comment();

        comment.setAuthor("Flavius");
        comment.setText("Demo content");

        commentService.publishComment(comment);
    }

}
