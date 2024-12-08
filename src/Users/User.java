package Users;

import CommentThreads.Comment;
import Users.Actions.UserAction;
import Users.Roles.Role;

import java.util.ArrayList;

public class User {
    String name;
    Role role;
    ArrayList<UserAction> history = new ArrayList<>();

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public boolean DoAction(UserAction userAction) {
        userAction.setUser(this);

        if (!role.ValidateAction(userAction))
            return false;

        history.add(userAction);
        userAction.execute();
        return true;
    }

    public void ReceiveNotification(Comment comment){
        System.out.println("[System to: " + name +"]" + " Comment from " + comment.author + " : " + comment.text);
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String output = "[" + name + ", " + role + "]";
        return output;
    }
}
