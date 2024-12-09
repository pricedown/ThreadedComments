package Users.Permission;

import Users.Actions.UserAction;

public class DeletePermission implements Permission {
    public boolean isAllowed(UserAction userAction) {
        return userAction.getType() == UserAction.UserActionType.Delete;
    }
}