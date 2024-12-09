package Users.Actions;

import CommentThreads.Post;
import Users.User;

import java.util.Date;

public class DeleteComment extends UserAction {
    public DeleteComment(User user, Post post, int index) {
        super(user, new Date(), post, index);
        actionType = UserActionType.Delete;
    }

    public DeleteComment(Post post, int index) {
        super(new Date(), post, index);
        actionType = UserActionType.Delete;
    }


    public boolean execute() {
        if (!user.role.isPermittedAction(this)) {
            System.out.println("User cannot delete this comment");
            return false;
        }
        comment.DeleteComment();

        return true;
    }

}
