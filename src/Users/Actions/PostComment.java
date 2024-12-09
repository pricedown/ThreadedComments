package Users.Actions;

import CommentThreads.Comment;
import CommentThreads.Post;

import java.util.Date;

public class PostComment extends UserAction {
    private String text;

    public PostComment(Post post, int index, String text) {
        super(new Date(), post, index);
        actionType = UserActionType.Post;

        this.text = text;
    }


    public boolean execute() {
        if (!user.role.isPermittedAction(this)) {
            System.out.println("User cannot post comments");
            return false;
        }
        comment.AddComment(new Comment(user, date, text));

        return true;
    }
}
