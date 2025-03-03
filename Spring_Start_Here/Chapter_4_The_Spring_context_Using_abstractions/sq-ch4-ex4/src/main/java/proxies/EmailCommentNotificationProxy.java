package proxies;

import models.Comment;

public class EmailCommentNotificationProxy implements CommentNotificationProxy{

    @Override
    public void sendComment(Comment comment){
        System.out.println("Send comment with text: " + comment.getText());
    }

}
