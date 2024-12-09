package Users.Permission;

import java.util.HashMap;
import java.util.Map;

public class PermissionFactory {

    private static final Map<Character, Permission> permChars = new HashMap<>();
    static {
        permChars.put('p', new PostPermission());
        permChars.put('e', new EditPermission());
        permChars.put('d', new DeletePermission());
        permChars.put('r', new RetractPermission());
    }

    public static Permission createPermission(Character character) {
        return permChars.get(character);
    }

    public static Character permChar(Permission permission) {
        for (Map.Entry<Character, Permission> entry : permChars.entrySet()) {
            if (entry.getValue().getClass().equals(permission.getClass())) {
                return entry.getKey();
            }
        }
        return null;
    }

}

