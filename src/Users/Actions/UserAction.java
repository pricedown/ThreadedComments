package Users.Actions;

import CommentThreads.Comment;
import CommentThreads.Post;
import Users.User;

import java.util.Date;

public abstract class UserAction {
    public enum UserActionType {
        Post, Delete, Edit
    }

    protected Post post;
    protected User user;
    protected Date date;
    protected Comment comment;
    protected UserActionType actionType;

    public UserAction(Date date, Post post, int index/*, Comment comment*/) {
        this.date = date;
        this.post = post;
        this.comment = post.getComment(index);
    }

    public UserAction(User user, Date date, Post post, int index/*, Comment comment*/) {
        this.user = user;
        this.date = date;
        this.post = post;
        this.comment = post.getComment(index);
    }

    public abstract boolean execute();

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public Date getDate() {return date;}
    public Comment getComment() {return comment;}
    public UserActionType getType() {return actionType;}
}
