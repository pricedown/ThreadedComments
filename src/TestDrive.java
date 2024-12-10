import CommentThreads.Post;
import Users.*;
import Users.Actions.CommentAction.*;
import Users.Actions.UserAction.*;
import Users.Permission.*;
import Users.Roles.*;

import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) {
        User joshua = new User("Joshua", RoleFactory.createRole("commenter"));
        User joseph = new User("Joseph", RoleFactory.createRole("commenter"));
        User murat = new User("Murat", RoleFactory.createRole("commenter"));

        Post post = new Post(joshua, "Hello, this is my post!");
        joseph.DoAction(new PostComment(post, 0, "Hi this is my reply!"));

        post.users.add(murat);
        System.out.println("\n" + post.display());

        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            /*
            System.out.println("a: action mode  "
                    + "u: user mode  "
                    + "q: quit  "
                    + "p: print  ");
             */

            System.out.print("mode ([a]ction [u]ser [q]uit [p]rint): ");
            input = scanner.nextLine().trim();

            if (input.equals("a")) {
                actionMode(post);
            } else if (input.equals("u")) {
                userMode(post);
            } else if (input.equals("p") || input.equals("print")) {
                System.out.println("\n" + post);
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
            System.out.print("action (q to quit): ");
            input = scanner.nextLine().trim();

            if (input.equals("q"))
                break;

            if (input.equals("print") || input.equals("p")) {
                System.out.println("\n" + post);
                continue;
            }

            CommentAction action = CommentActionFactory.fromString(input, post);

            if (action == null) {
                //System.out.println("Invalid action");
            } else {
                if (action.execute())
                    System.out.println("\n" + post.display());
                else
                    System.out.println("Action failed");
            }
        }
    }

    private static void userMode(Post post) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("user (q to quit): ");
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
