package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var commentService = context.getBean(CommentService.class);
        var userService = context.getBean(UserService.class);

        boolean b1 = commentService.getCommentRepository() == userService.getCommentRepository();

        System.out.println(b1);
    }

}
