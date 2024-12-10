// Joshua Sinclair Chong

package Users.Actions.CommentAction;

import CommentThreads.Post;
import Users.User;

import java.util.Date;

public class EditComment extends CommentAction {
    private String newText;

    public EditComment(User user, Post post, int index, String newText) {
        super(user, new Date(), post, index);
        actionType = CommentActionType.Edit;

        this.newText = newText;
    }

    public EditComment(Post post, int index, String newText) {
        super(new Date(), post, index);
        actionType = CommentActionType.Edit;

        this.newText = newText;
    }

    public boolean execute() {
        if (!user.getRole().isPermittedAction(this)) {
            System.out.println("User cannot edit this comment");
            return false;
        }

        comment.EditComment(newText, date);
        return true;
    }
}
