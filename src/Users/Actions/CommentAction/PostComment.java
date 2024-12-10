// Joshua Sinclair Chong

package Users.Actions.CommentAction;

import CommentThreads.Comment;
import CommentThreads.Post;
import Users.User;

import java.util.Date;

public class PostComment extends CommentAction {
    private String text;

    public PostComment(Post post, int index, String text) {
        super(new Date(), post, index);
        actionType = CommentActionType.Post;

        this.text = text;
    }

    public PostComment(User user, Date date, Post post, int index, String text) {
        super(user, new Date(), post, index);
        actionType = CommentActionType.Post;
        this.text = text;
    }

    public PostComment(User user, Post post, int commentIndex, String postText) {
        super(user, new Date(), post, commentIndex);
        actionType = CommentActionType.Post;
        this.text = postText;
    }

    public boolean execute() {
        if (!user.getRole().isPermittedAction(this)) {
            System.out.println("User cannot post comments");
            return false;
        }

        if (post == null) {
            System.out.println("Post does not exist");
            return false;
        }

        comment.AddComment(new Comment(user, date, text));

        post.addUser(user);
        return true;
    }
}
