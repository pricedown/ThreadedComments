package Users.Permissions;

import Users.*;
import CommentThreads.*;

public class ViewerPermission implements Permission {
    public boolean Post(User user, Post post) {
        System.out.println(user.getName() + " cannot post.");
        return false;
    }

    public boolean Edit(User user, Comment comment, String newText) {
        System.out.println(user.getName() + " cannot edit.");
        return false;
    }

    public boolean Delete(User user, Comment comment) {
        System.out.println(user.getName() + " cannot delete.");
        return false;
    }
}
