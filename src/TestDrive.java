import CommentThreads.Comment;
import CommentThreads.Post;
import Users.*;
import Users.Actions.EditComment;
import Users.Actions.PostComment;
import Users.Roles.Commenter;
import Users.Roles.General;
import Users.Roles.OriginalPoster;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TestDrive {
    public static void main(String[] args) {
        System.out.println("[Threaded Comments Test]\n");

        // Setup

        ArrayList<User> users = new ArrayList<User>();
        User joshua = new User("Joshua", new OriginalPoster());
        User joseph = new User("Joseph", new General());
        User murat = new User("Murat", new General());
        users.add(joshua);
        users.add(joseph);
        users.add(murat);

        System.out.println(users + "\n");


        Post post = new Post(joshua, "The Post. Index should be 0");
        joshua.DoAction(new PostComment(post, 0, "First comment; index? 1"));
        murat.DoAction(new PostComment(post, 0, "Index ? 2"));
        joseph.DoAction(new PostComment(post, 1, "Index ? 3"));
        System.out.println(post.display());

        Post post2 = new Post(murat, "New Post. Index ? 0");
        joshua.DoAction(new PostComment(post2, 0, "First comment. index ? 1"));
        System.out.println(post2.display());


        // Information about dates:
        // Year needs to have -1900
        // Months start at 0

/*        murat.DoAction(new PostComment("Comment 1", base));
        joseph.DoAction(new PostComment("Comment 2", base));
        joshua.DoAction(new PostComment("Comment 3", base));

        joshua.DoAction(new PostComment("Comment 1-1", base.children.get(0)));
        joseph.DoAction(new PostComment("Comment 1-2", base.children.get(0)));
        joshua.DoAction(new PostComment("Comment 2-1", base.children.get(1)));*/

/*        Comment base = new Comment(joshua, new Date(2024-1900, Calendar.DECEMBER, 1), "Cats are objectively the best animal");

        murat.DoAction(new PostComment("Comment 1", base));
        joseph.DoAction(new PostComment("Comment 2", base));
        joshua.DoAction(new PostComment("Comment 3", base));

        joshua.DoAction(new PostComment("Comment 1-1", base.children.get(0)));
        joseph.DoAction(new PostComment("Comment 1-2", base.children.get(0)));
        joshua.DoAction(new PostComment("Comment 2-1", base.children.get(1)));*/

        //joshua.DoAction(new EditComment("Otters are objectively the best animal", base, new Date(2024-1900, Calendar.DECEMBER, 5)));

        //Comment.getDateDiff(new Date(2022, 3, 1), new Date(), TimeUnit.MINUTES);


        /*
        System.out.println(new Date(2024 - 1901, 11, 6));
        System.out.println(new Date());
        System.out.println(Comment.computeDiff(new Date(2023 - 1900, 11, 6), new Date()));
        System.out.println(Comment.getRelevantTimeDiff(new Date(2023 - 1900, 11, 6), new Date()));
        */


        //System.out.println(base.display());

        System.out.println(users + "\n");

        // User Input: As a stretch goal

    }

    public void OutputMenu() {

    }
}
