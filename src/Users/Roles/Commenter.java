package Users.Roles;

import Users.Actions.UserAction;

public class Commenter implements Role {
    public boolean ValidateAction(UserAction userAction) {
        switch (userAction.getType()){
            case Post -> {
                return true;
            }
            case Delete -> {
                return (userAction.getComment().author == userAction.getUser());
            }
            case Edit -> {
                return (userAction.getComment().author == userAction.getUser());
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "Commenter";
    }
}
