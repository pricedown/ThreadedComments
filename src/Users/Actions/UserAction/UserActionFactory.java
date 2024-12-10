// Joseph Isaacs

package Users.Actions.UserAction;

import CommentThreads.Post;
import Users.Actions.CommentAction.CommentAction;
import Users.Actions.CommentAction.DeleteComment;
import Users.Actions.CommentAction.EditComment;
import Users.Actions.CommentAction.PostComment;
import Users.Permission.Permission;
import Users.Permission.PermissionFactory;
import Users.User;

public class UserActionFactory {
    public static UserAction fromString(String actionString, Post post) {
        String[] parts = actionString.split("\\|"); // Delimiter is pipe (|)

        if (parts.length < 3) {
            System.out.println("Invalid action");
            return null;
        }

        String username = parts[0].trim();
        String actionType = parts[1].trim().toLowerCase();
        String permissionStr = parts[2].trim();

        User user = post.findUser(username);

        if (user == null) {
            System.out.println("User not found");
            return null;
        }

        Permission permission = PermissionFactory.createPermission(permissionStr.charAt(0));

        switch (actionType.toLowerCase()) {
            case "grant":
                return new GrantPermission(user, permission);
            case "revoke":
                return new RevokePermission(user, permission);
            default:
                System.out.println("Unknown action type");
                return null;
        }
    }
}
