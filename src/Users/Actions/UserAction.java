package Users.Actions;

import CommentThreads.Comment;
import Users.User;

import java.util.Date;

public abstract class UserAction {
    public enum UserActionType {
        Post, Delete, Edit
    }

    protected User user;
    protected Date date;
    protected Comment comment;
    protected UserActionType actionType;

    public UserAction(Date date, Comment comment) {
        this.date = date;
        this.comment = comment;
    }

    public abstract void execute();

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public Date getDate() {return date;}
    public Comment getComment() {return comment;}
    public UserActionType getType() {return actionType;}
}
