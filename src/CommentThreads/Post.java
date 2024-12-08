package CommentThreads;

import Users.User;

import java.util.ArrayList;
import java.util.UUID;

public class Post extends Comment{
    //public Map<UUID, Comment>

    public final Comment parent = null;

    public ArrayList<Comment> comments = new ArrayList<>();

    public Post(User user, String text) {
        super(user, text);
        originalPost = this;
        comments.add(this);
    }

    public Comment getComment(int index) {
        return comments.get(index);
    }

    //public Comment getComment(UUID id) {}
}
