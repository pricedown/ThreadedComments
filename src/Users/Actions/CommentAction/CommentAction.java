// Joseph Isaacs

package Users.Actions.CommentAction;

import CommentThreads.Comment;
import CommentThreads.Post;
import Users.User;

import java.util.Date;

public abstract class CommentAction {
    public enum CommentActionType {
        Post, Delete, Edit
    }

    protected Post post;
    protected User user;
    protected Date date;
    protected Comment comment;
    protected CommentActionType actionType;

    public CommentAction(User user, Date date, Post post, int index) {
        this.user = user;
        this.date = date;
        this.post = post;
        this.comment = post.getComment(index);
    }

    public CommentAction(Date date, Post post, int index) {
        this.user = null;
        this.date = date;
        this.post = post;
        this.comment = post.getComment(index);
    }

    public abstract boolean execute();

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public Date getDate() {return date;}
    public Comment getComment() {return comment;}
    public CommentActionType getType() {return actionType;}
}
