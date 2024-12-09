package Users.Permissions;

import Users.*;
import CommentThreads.*;

import java.util.Date;

public class AdminPermission implements Permission {
    public boolean Post(User user, Post post) {
        System.out.println(user.getName() + " posted: " + post.getText());
        return true;
    }

    public boolean Edit(User user, Comment comment, String newText) {
        comment.EditComment(newText, new Date());
        System.out.println(user.getName() + " edited comment: " + newText);
        return true;
    }

    public boolean Delete(User user, Comment comment) {
        comment.DeleteComment();
        System.out.println(user.getName() + " deleted comment: " + comment.getText());
        return true;
    }
}
