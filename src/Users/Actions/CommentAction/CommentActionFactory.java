// Joseph Isaacs

package Users.Actions.CommentAction;

import CommentThreads.Post;
import Users.User;

public class CommentActionFactory {

    public static CommentAction fromString(String actionString, Post post) {
        String[] parts = actionString.split("\\|"); // Delimiter is pipe (|)

        if (parts.length < 2) {
            System.out.println("Invalid action");
            return null;
        }

        String username = parts[0].trim();
        String actionType = parts[1].trim();
        User user = post.findUser(username);

        if (user == null) {
            System.out.println("User not found");
            return null;
        }

        int commentIndex;
        if (parts.length > 2)
            commentIndex = Integer.parseInt(parts[2].trim());
        else
            commentIndex = -1;

        switch (actionType.toLowerCase()) {
            case "post":
                if (parts.length < 4) {
                    System.out.println("Missing comment text");
                    return null;
                }
                String postText = parts[3].trim();
                return new PostComment(user, post, commentIndex, postText);

            case "edit":
                if (parts.length < 4) {
                    System.out.println("Missing edit text");
                    return null;
                }
                String editText = parts[3].trim();
                return new EditComment(user, post, commentIndex, editText);

            case "delete":
                return new DeleteComment(user, post, commentIndex);

            default:
                System.out.println("Unknown action type");
                return null;
        }
    }
}