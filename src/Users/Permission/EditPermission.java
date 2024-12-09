package Users.Permission;

import Users.Actions.UserAction;

public class EditPermission implements Permission {
    public boolean isAllowed(UserAction userAction) {
        // editors can only edit their own comments
        return (userAction.getUser().equals(userAction.getComment().author))
                && (userAction.getType() == UserAction.UserActionType.Edit);
    }
}