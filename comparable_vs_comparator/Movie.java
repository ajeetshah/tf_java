import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * comparable (compareTo) : for natural sorting
 */

class Movie implements Comparable<Movie> {
    private String name;
    private double rating;
    private int year;

    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public double getRating() {
        return this.rating;
    }

    public String getName() {
        return this.name;
    }

    public int compareTo(Movie m) {
        return this.year - m.year; // asc order
    }

    @Override
    public String toString() {
        return this.name + "-" + this.rating + "-" + this.year;
    }
}

class App {
    public static void main(String[] args) {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Hello", 10, 2000));
        list.add(new Movie("Hi", 6, 2010));
        list.add(new Movie("Alice", 4, 2009));
        list.add(new Movie("Bob", 8, 2025));

        for (Movie m: list) {
            System.out.println(m);
        }

        /*
        Collections.sort(list);
        System.out.println("\nSorted: \n");
        for (Movie m: list) {
            System.out.println(m);
        }
        */

        Collections.sort(list, new RatingCompare());
        System.out.println("\nSorted by Rating: \n");
        for (Movie m: list) {
            System.out.println(m);
        }

        Collections.sort(list, new NameCompare());
        System.out.println("\nSorted by Name: \n");
        for (Movie m: list) {
            System.out.println(m);
        }
    }
}

// ---

class RatingCompare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return Double.compare(m1.getRating(), m2.getRating()); // asc order
    }
}

class NameCompare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getName().compareTo(m2.getName()); // asc order
    }
}

