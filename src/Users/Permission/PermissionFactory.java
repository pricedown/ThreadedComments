// Joseph Isaacs

package Users.Permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionFactory {

    private static final List<Permission> permissions = new ArrayList<Permission>() {{
        add(new EditPermission());
        add(new PostPermission());
        add(new DeletePermission());
        add(new RetractPermission());
    }};

    public static Permission createPermission(Character character) {
        for (Permission p : permissions) {
            if (p.permChar().equals(character)) {
                return p;
            }
        }
        return null;
    }

    public static Character permChar(Permission permission) {
        for (Permission p : permissions) {
            if (p.equals(permission)) {
                return p.permChar();
            }
        }
        return null;
    }

}

