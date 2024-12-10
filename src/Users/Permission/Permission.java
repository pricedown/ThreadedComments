// Joseph Isaacs

package Users.Permission;

import Users.Actions.CommentAction.CommentAction;

public interface Permission {
    boolean isAllowed(CommentAction commentAction);
    Character permChar();
}
