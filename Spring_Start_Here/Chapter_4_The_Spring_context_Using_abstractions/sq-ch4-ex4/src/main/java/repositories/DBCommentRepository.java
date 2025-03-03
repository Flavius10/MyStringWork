package repositories;

import models.Comment;

public class DBCommentRepository implements CommentRepository{

    @Override
    public void storeComment(Comment comment){
        System.out.println("Store the comment with message: " + comment.getText());
    }

}
