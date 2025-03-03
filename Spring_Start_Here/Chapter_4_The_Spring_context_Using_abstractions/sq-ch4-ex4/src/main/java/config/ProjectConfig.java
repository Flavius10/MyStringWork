package config;

import models.Comment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import proxies.CommentNotificationProxy;
import proxies.EmailCommentNotificationProxy;
import repositories.CommentRepository;
import repositories.DBCommentRepository;
import services.CommentService;

@Configuration
public class ProjectConfig {

    @Bean
    CommentRepository commentRepository(){
        return new DBCommentRepository();
    }

    @Bean
    CommentNotificationProxy commentNotificationProxy(){
        return new EmailCommentNotificationProxy();
    }

    @Bean
    CommentService commentService(
            CommentRepository commentRepository,
            CommentNotificationProxy commentNotificationProxy){
        return new CommentService(commentRepository, commentNotificationProxy);
    }

}
