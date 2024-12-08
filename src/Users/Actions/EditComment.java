package Users.Actions;

import CommentThreads.Comment;
import CommentThreads.Post;

import java.util.Date;

public class EditComment extends UserAction {
    private String newText;

    public EditComment(Post post, int index, String newText) {
        super(new Date(), post, index);
        actionType = UserActionType.Edit;

        this.newText = newText;
    }

    public EditComment(Post post, int index, String newText, Date date) {
        super(date, post, index);
        actionType = UserActionType.Edit;

        this.newText = newText;
    }

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
