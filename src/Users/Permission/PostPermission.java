// Joseph Isaacs

package Users.Permission;

import Users.Actions.CommentAction.CommentAction;

public class PostPermission implements Permission {
    public boolean isAllowed(CommentAction commentAction) {
        return commentAction.getType() == CommentAction.CommentActionType.Post;
    }

    public Character permChar() {
        return 'p';
    }

    public boolean equals(Object o) {
        return o instanceof PostPermission;
    }
}