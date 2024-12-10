// Joshua Sinclair Chong

package Users.Actions.UserAction;

import Users.Actions.Command;
import Users.User;

import java.util.Date;

public abstract class UserAction implements Command {
    protected User user;
    protected Date date;

    public UserAction(User user) {
        this.user = user;
        this.date = new Date();
    }

    public abstract boolean execute();
}
