import CommentThreads.Post;
import Users.*;
import Users.Actions.CommentAction.CommentAction;
import Users.Actions.CommentAction.CommentActionFactory;
import Users.Actions.UserAction.UserAction;
import Users.Actions.UserAction.UserActionFactory;
import Users.Permission.Permission;
import Users.Permission.PermissionFactory;
import Users.Permission.RetractPermission;
import Users.Roles.*;

import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) {

        System.out.println("[Threaded Comments Test]");

        User joshua = new User("Joshua", RoleFactory.createRole("commenter"));
        User joseph = new User("Joseph", RoleFactory.createRole("commenter"));
        User murat = new User("Murat", RoleFactory.createRole("commenter"));

        Post post = new Post(joshua, "Hello, this is my post!");
        post.users.add(joseph);
        post.users.add(murat);
        System.out.println(post.display());

        System.out.println(joseph);
        joseph.role.removePermission(new RetractPermission());

        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("a: action mode");
            System.out.println("u: user mode");
            System.out.println("q: quit");

            System.out.println("select: ");
            input = scanner.nextLine().trim();

            if (input.equals("a")) {
                actionMode(post);
            } else if (input.equals("u")) {
                userMode(post);
            } else if (input.equals("q")) {
                break;
            }

        }
        scanner.close();
    }

    private static void actionMode(Post post) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("action (q to quit):");
            input = scanner.nextLine().trim();

            if (input.equals("q"))
                break;

            if (input.equals("print") || input.equals("p")) {
                System.out.println(post);
                continue;
            }

            CommentAction action = CommentActionFactory.fromString(input, post);

            if (action == null) {
                //System.out.println("Invalid action");
            } else {
                if (action.execute())
                    System.out.println(post.display());
                else
                    System.out.println("Action failed");
            }
        }
    }

    private static void userMode(Post post) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("user (q to quit):");
            input = scanner.nextLine().trim();

            if (input.equals("q"))
                break;

            if (input.equals("print") || input.equals("p")) {
                for (User user : post.users) {
                    System.out.println(user);
                }
                continue;
            }

            UserAction action = UserActionFactory.fromString(input, post);

            if (action == null) {
                //System.out.println("Invalid action");
            } else {
                if (action.execute())
                    for (User user : post.users) {
                        System.out.println(user);
                    }
                else
                    System.out.println("Action failed");
            }
        }
    }
}
