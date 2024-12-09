package Users.Roles;

import Users.Actions.UserAction;

import Users.Permission.*;

import java.util.HashSet;
import java.util.Set;

import static Users.Permission.PermissionFactory.permChar;

public class Role {
    private Set<Permission> permissions = new HashSet<>();

    public boolean isPermittedAction(UserAction userAction) {
        for (Permission permission : permissions) {
            if (permission.isAllowed(userAction)) {
                return true;
            }
        }
        return false;
    }

    public void addPermission(Permission permission) {
        permissions.add(permission);
    }

    public void removePermission(Permission permission) {
        permissions.remove(permission);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Permission permission : permissions) {
            Character permissionChar = permChar(permission);
            if (permissionChar != null) {
                result.append(permissionChar);
            }
        }
        return result.toString();
    }
}