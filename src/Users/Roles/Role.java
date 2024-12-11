// Joshua Sinclair Chong

package Users.Roles;

import Users.Actions.CommentAction.CommentAction;

import Users.Permission.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Role {
    private Set<Permission> permissions = new HashSet<>();

    public boolean isPermittedAction(CommentAction commentAction) {
        for (Permission permission : permissions) {
            if (permission.isAllowed(commentAction)) {
                return true;
            }
        }
        return false;
    }

    public void addPermission(Permission permission) {
        for (Permission perm : permissions) {
            if (permission.equals(perm)) {
                return;
            }
        }
        permissions.add(permission);
    }

    public void removePermission(Permission permission) {
        for (Permission perm : permissions) {
            if (permission.equals(perm)) {
                permissions.remove(perm);
                return;
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Permission permission : permissions) {
            Character permissionChar = permission.permChar();
            if (permissionChar != null) {
                result.append(permissionChar);
            }
        }
        char[] a = result.toString().toCharArray();
        Arrays.sort(a);
        return Arrays.toString(a);
    }
}