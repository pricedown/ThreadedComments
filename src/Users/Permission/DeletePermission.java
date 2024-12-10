package Users.Permission;

import Users.Actions.CommentAction.CommentAction;

public class DeletePermission implements Permission {
    public boolean isAllowed(CommentAction commentAction) {
        return commentAction.getType() == CommentAction.CommentActionType.Delete;
    }
    public boolean equals(Object o) {
        return o instanceof DeletePermission;
    }
}