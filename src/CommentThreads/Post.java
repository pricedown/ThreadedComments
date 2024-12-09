package CommentThreads;

import Users.User;

import java.util.ArrayList;
import java.util.UUID;

public class Post extends Comment {
    //public Map<UUID, Comment>

    public final Comment parent = null;
    // TODO: add archived stated which prevents new comments from being added
    // the admins and original poster can do this, (or OP can delete post?)
    // this means that the addComment() should go through this

    public ArrayList<Comment> comments = new ArrayList<>();

    public Post(User user, String text) {
        super(user, text);
        originalPost = this;
        comments.add(this);
        index = 0;
    }

    public Comment getComment(int index) {
        return comments.get(index);
    }

    //public Comment getComment(UUID id) {}
}
