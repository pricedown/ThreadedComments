import CommentThreads.Comment;
import Users.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestDrive {
    public static void main(String[] args) {
        System.out.println("[Threaded Comments Test]");

        User joshua = new User("Joshua");
        User joseph = new User("Joseph");

        Comment base = new Comment(joshua, new Date(2024, 12, 1), "This is a base comment");

        base.AddComment(new Comment(joseph, new Date(2022, 2, 1),"Comment 2"));
        base.AddComment(new Comment(joshua, new Date(2022, 2, 1), "Comment 3"));

        base.children.get(0).AddComment(new Comment(joshua, new Date(2022, 3, 1),"Comment 2-1"));
        base.children.get(0).AddComment(new Comment(joseph, new Date(2022, 3, 1),"Comment 2-2"));

        //Comment.getDateDiff(new Date(2022, 3, 1), new Date(), TimeUnit.MINUTES);

/*        System.out.println(new Date(2024 - 1901, 11, 6));
        System.out.println(new Date());
        System.out.println(Comment.getDateDiff(new Date(2024 - 1901, 11, 6), new Date(), TimeUnit.DAYS));*/

        System.out.println(base.display());
    }
}
