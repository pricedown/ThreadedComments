package Users.Actions;

import CommentThreads.Comment;
import CommentThreads.Post;
import Users.User;

import java.util.Date;

public class PostComment extends UserAction {
    private String text;

    public PostComment(Post post, int index, String text) {
        super(new Date(), post, index);
        actionType = UserActionType.Post;

        this.text = text;
    }

    public PostComment(User user, Date date, Post post, int index, String text) {
        super(user, new Date(), post, index);
        actionType = UserActionType.Post;
        this.text = text;
    }

    public PostComment(User user, Post post, int commentIndex, String postText) {
        super(user, new Date(), post, commentIndex);
        actionType = UserActionType.Post;
        this.text = postText;
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
