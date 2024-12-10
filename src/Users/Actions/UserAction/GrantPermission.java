// Joseph Isaacs

package Users.Actions.UserAction;

import Users.Permission.Permission;
import Users.User;

public class GrantPermission extends UserAction {
    Permission permission;
    public GrantPermission(User user, Permission permission) {
        super(user);
        this.permission = permission;
    }

    @Override
    public boolean execute() {
        user.getRole().addPermission(permission);
        return true;
    }
}
