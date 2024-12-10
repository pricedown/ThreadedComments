// Joseph Isaacs

package Users.Permission;

import Users.Actions.CommentAction.CommentAction;

public class EditPermission implements Permission {
    public boolean isAllowed(CommentAction commentAction) {
        // editors can only edit their own comments
        // TODO: catch error
        return (commentAction.getUser().equals(commentAction.getComment().getAuthor()))
                && (commentAction.getType() == CommentAction.CommentActionType.Edit);
    }
    public boolean equals(Object o) {
        return o instanceof EditPermission;
    }
}