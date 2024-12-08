package Users.Actions;

import CommentThreads.Comment;
import Users.User;

import java.util.Date;

public class DeleteComment extends UserAction {

    public DeleteComment(Comment comment) {
        super(new Date(), comment);
        actionType = UserActionType.Delete;
    }

    public DeleteComment(Comment comment, Date date) {
        super(date, comment);
        actionType = UserActionType.Delete;
    }

    public void execute() {

    }

}
