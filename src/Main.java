import problems.ImplementationClasses.FoodRatings;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        String[] food = {"kimchi","miso","sushi","moussaka","ramen","bulgogi"};
        String[] cuisine = {"korean","japanese","japanese","greek","japanese","korean"};
        int[] rating = {9,12,8,15,14,7};

        FoodRatings foodRatings = new FoodRatings(food, cuisine, rating);

        System.out.println(foodRatings.highestRated("korean"));
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi", 16);
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("ramen",16);
        System.out.println(foodRatings.highestRated("japanese"));

    }
}
