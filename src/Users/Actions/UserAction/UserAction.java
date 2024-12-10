package Users.Actions.UserAction;

import Users.User;

public abstract class UserAction {
    User user;
    public UserAction(User user) {
        this.user = user;
    }
    public abstract boolean execute();
}
