package Users.Actions;

import CommentThreads.Comment;

import java.util.Date;

public class EditComment extends UserAction {
    private String newText;

    public EditComment(String newText, Comment comment) {
        super(new Date(), comment);
        actionType = UserActionType.Edit;

        this.newText = newText;
    }

    public EditComment(String newText, Comment comment, Date date) {
        super(date, comment);
        actionType = UserActionType.Edit;

        this.newText = newText;
    }

    public void execute() {
        comment.EditComment(newText, date);
    }
}
