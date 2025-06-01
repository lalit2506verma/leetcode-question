package problems.ImplementationClasses;

public class Design_Twitter_Client {
    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.follow(1, 2);
        t.follow(1, 3);
        t.follow(4, 6);
        t.follow(2, 6);
        t.follow(3, 1);

        t.displayFollowerList();

        System.out.println("---------------------");

        t.unfollow(1,3);
        t.unfollow(3, 6);
        t.follow(1,7);
        t.follow(4, 7);
        t.unfollow(4, 6);

        t.displayFollowerList();
    }

}
