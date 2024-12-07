package Users;

import CommentThreads.Comment;

public class User {
    String name;
    // Role

    public User(String name) {
        this.name = name;
    }

    public void Notify(Comment comment){


    }

    @Override
    public String toString() {
        return name;
    }
}
