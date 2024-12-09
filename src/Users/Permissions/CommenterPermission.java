package Users.Permissions;

import Users.*;
import CommentThreads.*;

import java.util.Date;

public class CommenterPermission implements Permission {
    public boolean Post(User user, Post post) {
        System.out.println(user.getName() + " posted: " + post.getText());
        return true;
    }

    public boolean Edit(User user, Comment comment, String newText) {
        if (user.getName().equals(comment.getAuthor().getName())) {
            comment.EditComment(newText, new Date());
            System.out.println(user.getName() + " edited comment: " + newText);
            return true;
        } else {
            System.out.println(user.getName() + " cannot edit this comment because it's not theirs.");
            return false;
        }
    }

    public boolean Delete(User user, Comment comment) {
        if (user.getName().equals(comment.getAuthor().getName())) {
            comment.DeleteComment();
            System.out.println(user.getName() + " deleted comment: " + comment.getText());
            return true;
        } else {
            System.out.println(user.getName() + " cannot delete this comment because it's not theirs.");
            return false;
        }
    }
}

