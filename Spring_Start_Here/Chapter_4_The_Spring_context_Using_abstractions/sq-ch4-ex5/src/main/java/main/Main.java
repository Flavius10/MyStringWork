package main;

import config.ProjectConfig;
import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Flavius");

        var commentService = context.getBean(CommentService.class);

        commentService.pushComment(comment);
    }

}
