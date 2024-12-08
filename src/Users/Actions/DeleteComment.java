package Users.Actions;

import CommentThreads.Comment;
import CommentThreads.Post;

import java.util.Date;

public class DeleteComment extends UserAction {

    public DeleteComment(Post post, int index) {
        super(new Date(), post, index);
    }

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
