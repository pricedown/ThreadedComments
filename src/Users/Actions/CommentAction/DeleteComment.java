// Joshua Sinclair Chong

package Users.Actions.CommentAction;

import CommentThreads.Post;
import Users.User;

import java.util.Date;

public class DeleteComment extends CommentAction {
    public DeleteComment(User user, Post post, int index) {
        super(user, new Date(), post, index);
        actionType = CommentActionType.Delete;
    }

    public DeleteComment(Post post, int index) {
        super(new Date(), post, index);
        actionType = CommentActionType.Delete;
    }


    public boolean execute() {
        if (!user.getRole().isPermittedAction(this)) {
            System.out.println("User cannot delete this comment");
            return false;
        }
        comment.DeleteComment();

        return true;
    }

}
