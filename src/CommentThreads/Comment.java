package CommentThreads;

import Users.User;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Comment {
    public User author;
    UUID UUID;
    Date date;
    public String text;

    boolean edited = false;
    Date editedDate;

    public Comment parent;
    public ArrayList<Comment> children = new ArrayList<Comment>();
    int indentation = 0;

    ArrayList<User> subscribers = new ArrayList<User>();

    public Comment(User user, String text){
        this.author = user;
        this.date = new Date();
        this.text = text;
    }

    public Comment(User user, Date date, String text){
        this.author = user;
        this.date = date;
        this.text = text;
        this.UUID = java.util.UUID.randomUUID();
    }

    public void NotifySubscribers(Comment comment){
        for (User u : subscribers){
            u.ReceiveNotification(comment);
        }
    }

    // Actions

    public void AddComment(Comment comment){
        comment.parent = this;
        comment.indentation = this.indentation + 1;

        children.add(comment);

        NotifySubscribers(comment);
        subscribers.add(comment.author);
    }

    public void EditComment(String newText, Date editedDate) {
        text = newText;
        this.edited = true;
        this.editedDate = editedDate;
    }

    // Display

    @Override
    public String toString() {
        String output = "";

        output += AddIndentation() + author.getName() + "\t Posted: " + date + "\n";
        if (edited) output += AddIndentation() + "Edited: " + editedDate + "\n";
        output += AddIndentation() + text + "\n";

        return output;
    }

    public String display() {
        String output = toString();

        for (Comment c : children) {
            output += c.display();
        }

        return output;
    }

    private String AddIndentation() {
        String output = "";

        for (int i = 0; i < indentation; i++)
            output += "\t";

        return output;
    }

    // time ago
    public static String getRelevantTimeDiff(Date date1, Date date2) {
        Map<TimeUnit,Long> time = computeDiff(date1, date2);
        String output = " just now";

        if (time.get(TimeUnit.DAYS) > 0) {
            output = time.get(TimeUnit.DAYS).toString();
            output += (time.get(TimeUnit.DAYS) == 1) ? " day ago" : " days ago";
            return output;
        }

        if (time.get(TimeUnit.HOURS) > 0) {
            output = time.get(TimeUnit.HOURS).toString();
            output += (time.get(TimeUnit.HOURS) == 1) ? " hour ago" : " hours ago";
            return output;
        }

        if (time.get(TimeUnit.MINUTES) > 0) {
            output += time.get(TimeUnit.MINUTES).toString();
            output += (time.get(TimeUnit.MINUTES) == 1) ? " minute ago" : " minutes ago";
            return output;
        }

        if (time.get(TimeUnit.SECONDS) > 0) {
            output += time.get(TimeUnit.SECONDS).toString();
            output += (time.get(TimeUnit.SECONDS) == 1) ? " second ago" : " seconds ago";
            return output;
        }

        return output;
    }

    // From: https://ideone.com/5dXeu6
    public static Map<TimeUnit,Long> computeDiff(Date date1, Date date2) {
        long diffInMillies = date2.getTime() - date1.getTime();
        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;
        for ( TimeUnit unit : units ) {
            long diff = unit.convert(milliesRest,TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;
            result.put(unit,diff);
        }
        return result;
    }
}
