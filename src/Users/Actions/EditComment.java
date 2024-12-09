package Users.Actions;

import CommentThreads.Post;
import Users.User;

import java.util.Date;

public class EditComment extends UserAction {
    private String newText;

    public EditComment(User user, Post post, int index, String newText) {
        super(user, new Date(), post, index);
        actionType = UserActionType.Edit;

        this.newText = newText;
    }

    public EditComment(Post post, int index, String newText) {
        super(new Date(), post, index);
        actionType = UserActionType.Edit;

        this.newText = newText;
    }

    public boolean execute() {
        if (!user.role.isPermittedAction(this)) {
            System.out.println("User cannot edit comments");
            return false;
        }

        if (!comment.EditComment(newText, date)) {
            System.out.println("Cannot edit this comment");
            return false;
        }

        return true;
    }
}
