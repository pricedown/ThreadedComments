package Users.Permission;

import Users.Actions.*;

public class PostPermission implements Permission {
    public boolean isAllowed(UserAction userAction) {
        return userAction.getType() == UserAction.UserActionType.Post;
    }
}