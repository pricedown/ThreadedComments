package CommentThreads;

import Users.User;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Comment {
    public User author;
    String UID;
    Date date;
    int indentation = 0;

    public String text;

    public Comment parent;
    public ArrayList<Comment> children = new ArrayList<Comment>();

    ArrayList<User> subscribers = new ArrayList<User>();

    public Comment(User user, Date date, String text){
        this.author = user;
        this.date = date;
        this.text = text;
    }

    public void AddComment(Comment comment){
        comment.parent = this;
        comment.indentation = this.indentation + 1;

        children.add(comment);

        NotifySubscribers(comment);
        subscribers.add(comment.author);
    }

    public void NotifySubscribers(Comment comment){
        for (User u : subscribers){
            u.Notify(comment);
        }
    }

    @Override
    public String toString() {
        String output = "";

        output += AddIndentation() + author.toString() + "\t" + getDateDiff(new Date(), date, TimeUnit.DAYS) + " days ago" + "\n";
        output += AddIndentation() + text + "\n";

        return output;
    }

    private String AddIndentation() {
        String output = "";

        for (int i = 0; i < indentation; i++)
            output += "\t";

        return output;
    }

    public String display() {
        String output = toString();

        for (Comment c : children) {
            output += c.display();
        }

        return output;
    }

    // The functions below are both taken from websites
    //https://stackoverflow.com/questions/1555262/calculating-the-difference-between-two-java-date-instances
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }

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
