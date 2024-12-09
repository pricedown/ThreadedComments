import CommentThreads.Post;
import Users.*;
import Users.Actions.*;
import Users.Roles.*;
import Users.Permission.*;

import java.util.ArrayList;
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

        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("action (q to exit):");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            UserAction action = UserActionFactory.fromString(input, post);

            if (action == null) {
                System.out.println("Invalid action");
            } else {
                if (action.execute())
                    System.out.println(post.display());
                else
                    System.out.println("Action failed");
            }
        }
        scanner.close();
    }
}
