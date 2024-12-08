package Users.Actions;

import CommentThreads.Comment;
import Users.User;

import java.util.Date;

public class PostComment extends UserAction {
    private String text;

    public PostComment(String text, Comment replyTo) {
        super(new Date(), replyTo);
        actionType = UserActionType.Post;

        this.text = text;
    }

    // In case you want to manually override the date since java doesnt have default params apparently
    public PostComment(String text, Comment replyTo, Date date) {
        super(date, replyTo);
        actionType = UserActionType.Post;

        this.text = text;
    }

    public void execute() {
        comment.AddComment(new Comment(user, date, text));
    }
}
