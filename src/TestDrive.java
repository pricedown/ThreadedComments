// Joseph Isaacs
// Joshua Sinclair Chong

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
        loop:
        while (true) {
            System.out.print("mode ([a]ction [u]ser [q]uit [p]rint): ");
            input = scanner.nextLine().trim();

            switch (input) {
                case "a":
                case "action":
                    actionMode(post);
                    break;
                case "u":
                case "user":
                    userMode(post);
                    break;
                case "p":
                case "print":
                    System.out.println("\n" + post.display());
                    break;
                case "q":
                case "quit":
                    break loop;
            }

        }
        scanner.close();
    }

    private static void actionMode(Post post) {
        Scanner scanner = new Scanner(System.in);
        String input;
        loop:
        while (true) {
            System.out.print("action (? for help): ");
            input = scanner.nextLine().trim();

            switch (input) {
                case "p":
                case "print":
                    System.out.println("\n" + post.display());
                    continue;
                case "q":
                case "quit":
                    break loop;
                case "?":
                    System.out.println("quit: q, print: p\naction: [user | post/edit/delete | index | info]");
                    continue;
            }

            CommentAction action = CommentActionFactory.fromString(input, post);

            if (action != null) {
                if (action.execute()) {
                    System.out.println("\n" + post.display());
                }
            }
        }
    }

    private static void userMode(Post post) {
        Scanner scanner = new Scanner(System.in);
        String input;
        loop:
        while (true) {
            System.out.print("user (? for help): ");
            input = scanner.nextLine().trim();

            switch (input) {
                case "p":
                case "print":
                    for (User user : post.users) {
                        System.out.println(user);
                    }
                    continue;
                case "q":
                case "quit":
                    break loop;
                case "?":
                    System.out.println("quit: q, print: p\nperms: [user | grant/revoke | e/r/p/d]");
                    continue;
            }

            UserAction action = UserActionFactory.fromString(input, post);

            if (action != null) {
                if (action.execute()) {
                    for (User user : post.users) {
                        System.out.println(user);
                    }
                }
            }
        }
    }
}
