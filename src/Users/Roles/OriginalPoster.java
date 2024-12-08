package Users.Roles;

import Users.Actions.EditComment;
import Users.Actions.UserAction;

public class OriginalPoster implements Role {
    public boolean ValidateAction(UserAction userAction) {
        switch (userAction.getType()){
            case Post -> {
                return true;
            }
            case Delete -> {
                return true;
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
        return "Original Poster";
    }
}
