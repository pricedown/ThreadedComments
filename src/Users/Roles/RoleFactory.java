package Users.Roles;

import Users.Permission.*;

public class RoleFactory {
    public static Role createCustomRole(String permissionsString) {
        Role customRole = new Role();

        for (char permissionChar : permissionsString.toCharArray()) {
            Permission permission = PermissionFactory.createPermission(permissionChar);
            if (permission != null) {
                customRole.addPermission(permission);
            }
        }

        return customRole;
    }

    public static Role createRole(String roleName) {
        Role role = null;

        switch (roleName.toLowerCase()) {
            case "admin":
                role = createAdmin();
                break;
            case "commenter":
                role = createCommenter();
                break;
            case "viewer":
                role = createViewer();
                break;
            default:
                throw new IllegalArgumentException("Unknown role: " + roleName);
        }

        return role;
    }

    public static Role createAdmin() {
        Role admin = new Role();
        admin.addPermission(new PostPermission());
        admin.addPermission(new EditPermission());
        admin.addPermission(new DeletePermission());
        admin.addPermission(new RetractPermission());
        return admin;
    }

    public static Role createCommenter() {
        Role commenter = new Role();
        commenter.addPermission(new PostPermission());
        commenter.addPermission(new EditPermission());
        commenter.addPermission(new RetractPermission());
        return commenter;
    }

    public static Role createViewer() {
        return new Role();
    }
}



