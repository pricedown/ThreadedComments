package Users.Actions;

import CommentThreads.Post;

import java.util.Date;

public class EditComment extends UserAction {
    private String newText;

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
        comment.EditComment(newText, date);

        return true;
    }
}
