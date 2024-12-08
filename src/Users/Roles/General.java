package Users.Roles;

import Users.Actions.UserAction;

public class General implements Role {
    public boolean ValidateAction(UserAction userAction) {
        switch (userAction.getType()){
            case Post -> {
                userAction.getUser().setRole(new Commenter());
                return true;
            }
            case Delete -> {
                return false;
            }
            case Edit -> {
                return false;
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "General User";
    }
}
