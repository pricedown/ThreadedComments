package Users.Permissions;

import Users.*;
import CommentThreads.*;

public interface Permission {
    boolean Post(User user, Post post);
    boolean Edit(User user, Comment comment, String newText);
    boolean Delete(User user, Comment comment);
}
