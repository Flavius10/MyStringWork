package proxies;

import models.Comment;
import org.springframework.stereotype.Component;

@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy{

    public void sendComment(Comment comment){
        System.out.println("Sending email with text: " + comment.getText());
    }
}
