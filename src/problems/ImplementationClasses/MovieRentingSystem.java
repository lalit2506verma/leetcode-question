package problems.ImplementationClasses;

import java.util.*;

public class MovieRentingSystem {
    HashMap<Integer, TreeSet<int[]>> availableMovies;
    TreeSet<int[]> rentedMovies;

    HashMap<String, Integer> prices;

    public MovieRentingSystem(int n, int[][] entries) {
        availableMovies = new HashMap<>();
        rentedMovies = new TreeSet<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]):
                (a[1] != b[1]) ? Integer.compare(a[1], b[1]):
                Integer.compare(a[2], b[2]));

        prices = new HashMap<>();

        for(int[] entry: entries){
            int shop = entry[0], movie = entry[1], price = entry[2];

            String key = shop + "_" + movie;
            prices.put(key, price);

            availableMovies.putIfAbsent(movie, new TreeSet<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]):
                    Integer.compare(a[1], b[1])));

            availableMovies.get(movie).add(new int[]{price, shop});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> list = new ArrayList<>();
        if(availableMovies.containsKey(movie)){
            int count = 0;

            for(int[] p : availableMovies.get(movie)){
                if(count == 5) break;
                list.add(p[1]);
                count++;
            }
        }
        return list;
    }

    public void rent(int shop, int movie) {
        String key = shop + "_" + movie;
        int price = prices.get(key);

        availableMovies.get(movie).remove(new int[]{price, shop});
        rentedMovies.add(new int[]{price, shop, movie});

    }

    public void drop(int shop, int movie) {
        String key = shop + "_" + movie;
        int price = prices.get(key);
        rentedMovies.remove(new int[] {price, shop, movie});
        availableMovies.get(movie).add(new int[]{price, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (int[] t : rentedMovies) {
            if (count == 5) break;
            result.add(Arrays.asList(t[1], t[2])); // {shop, movie}
            count++;
        }
        return result;
    }
}
