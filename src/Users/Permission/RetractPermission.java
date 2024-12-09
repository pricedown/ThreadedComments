package Users.Permission;

import Users.Actions.UserAction;

public class RetractPermission implements Permission {
    public boolean isAllowed(UserAction userAction) {
        // authors can always delete their own posts
        return userAction.getType() == UserAction.UserActionType.Delete
                && (userAction.getUser().equals(userAction.getComment().author));
    }
}
