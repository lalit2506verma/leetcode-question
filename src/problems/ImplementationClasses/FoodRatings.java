package problems.ImplementationClasses;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FoodRatings {
    HashMap<String, Food> foodToFoodMap;
    HashMap<String, PriorityQueue<Food>> cuisineToFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToFoodMap = new HashMap<>();
        cuisineToFoodMap = new HashMap<>();

        int n = foods.length;

        for(int i = 0; i < n; i++){
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            // Adding in the foodToFoodMapping
            foodToFoodMap.put(foods[i], f);

            // Adding in the foodToCuisineMapping
            cuisineToFoodMap
                    .computeIfAbsent(cuisines[i], k -> new PriorityQueue<>((o1, o2) -> {
                        if (o1.getRating() != o2.getRating()) {
                            return Integer.compare(o2.getRating(), o1.getRating());
                        }

                        return o1.getFood().compareTo(o2.getFood());
                    }) )
                    .add(f);
        }
    }

    public void changeRating(String food, int newRating) {
        Food f = foodToFoodMap.get(food);

        PriorityQueue<Food> q = cuisineToFoodMap.get(f.getCuisines());

        q.remove(f);
        f.setRating(newRating);
        q.add(f);

    }

    public String highestRated(String cuisine) {
        return cuisineToFoodMap.get(cuisine).peek().getFood();
    }
}

class Food{
    private String food;
    private String cuisines;
    private int rating;

    public Food(String food, String cuisines, int rating) {
        this.food = food;
        this.cuisines = cuisines;
        this.rating = rating;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
