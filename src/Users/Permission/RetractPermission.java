// Joseph Isaacs

package Users.Permission;

import Users.Actions.CommentAction.CommentAction;

public class RetractPermission implements Permission {
    public boolean isAllowed(CommentAction commentAction) {
        // authors can always delete their own posts
        return commentAction.getType() == CommentAction.CommentActionType.Delete
                && (commentAction.getUser().equals(commentAction.getComment().author));
    }
    public boolean equals(Object o) {
        return o instanceof RetractPermission;
    }
}
