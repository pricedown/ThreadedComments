package Users.Permission;

import Users.Actions.*;

public interface Permission {
    boolean isAllowed(UserAction userAction);
}
