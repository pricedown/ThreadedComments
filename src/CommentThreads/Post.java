// Joshua Sinclair Chong

package CommentThreads;

import Users.User;

import java.util.ArrayList;

public class Post extends Comment {
    public final Comment parent = null;

    protected ArrayList<Comment> comments = new ArrayList<>();
    protected ArrayList<User> users = new ArrayList<>();

    public Post(User user, String text) {
        super(user, text);
        originalPost = this;
        comments.add(this);
        index = 0;
        users.add(author);
    }

    public Comment getComment(int index) {
        if (index > comments.size())
            return null;
        return comments.get(index);
    }

    public User findUser(String username) {
        for (User u : users) {
            if (u.getName().equalsIgnoreCase(username)) {
                return u;
            }
        }
        return null;
    }

    public void addUser(User user) {
        if (!users.contains(user))
            users.add(user);
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
