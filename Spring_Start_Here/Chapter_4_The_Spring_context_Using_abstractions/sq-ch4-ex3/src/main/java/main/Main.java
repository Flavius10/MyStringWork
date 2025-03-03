package main;

import models.Comment;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Flavius");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
