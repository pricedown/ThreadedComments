package Users.Roles;

import Users.Actions.UserAction;

public interface Role {
    public boolean ValidateAction(UserAction userAction);
}
