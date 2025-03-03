package main;

import config.ProjectConfig;
import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

import java.lang.reflect.AnnotatedParameterizedType;
import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var commentService = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("Flavius");
        comment.setText("Demo comment");

        commentService.publishComment(comment);
        commentService.deleteComment(comment);
        commentService.editComment(comment);
    }

}
