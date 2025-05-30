package main;


import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {

    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var cs1 = context.getBean("commentService", CommentService.class);
        var cs2 = context.getBean("commentService", CommentService.class);

        boolean ok = cs1 == cs2;

        System.out.println(ok);
    }

}
