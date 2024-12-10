// Joseph Isaacs

package Users.Actions.UserAction;

import Users.Permission.Permission;
import Users.User;

public class RevokePermission extends UserAction {
    Permission permission;
    public RevokePermission(User user, Permission permission) {
        super(user);
        this.permission = permission;
    }

    @Override
    public boolean execute() {
        user.getRole().removePermission(permission);
        return true;
    }
}
