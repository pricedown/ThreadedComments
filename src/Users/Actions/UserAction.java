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

    public UserAction(Date date, Comment comment) {
        this.date = date;
        this.post = post;
        this.comment = comment;
        System.out.println("Decpreciated constructor! Use the one that takes in a post and index");
    }

    public abstract void execute();

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public Date getDate() {return date;}
    public Comment getComment() {return comment;}
    public UserActionType getType() {return actionType;}
}
