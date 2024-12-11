// Joshua Sinclair Chong

package Users;

import CommentThreads.Comment;
import CommentThreads.Observer;
import Users.Actions.CommentAction.CommentAction;
import Users.Roles.Role;

import java.util.ArrayList;

public class User implements Observer {
    private String name;
    private Role role;
    private ArrayList<CommentAction> commentHistory = new ArrayList<>();

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public boolean doAction(CommentAction commentAction) {
        commentAction.setUser(this);
        if (commentAction.execute()) {
            commentHistory.add(commentAction);
            return true;
        }
        return false;
    }

    public void notify(Comment comment){
        System.out.println("[System to: " + name +"]" + " Comment from " + comment.getAuthor() + " : " + comment.getText());
    }

    public Role getRole() {
        return this.role;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + role + "]";
    }
}
