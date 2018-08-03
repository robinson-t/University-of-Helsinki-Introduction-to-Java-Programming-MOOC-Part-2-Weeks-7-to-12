/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author tomro
 */
public class FilmComparator implements Comparator<Film>{
    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }
    
    

    @Override
    public int compare(Film o1, Film o2) {
        for (Film f : this.ratings.keySet()) {
            if (f.equals(o1)) {
                int averageo1 = 0;
                int no1 = 0;
                for (Rating r : this.ratings.get(f)) {
                    averageo1 += r.getValue();
                    no1++;
                }
                averageo1 /= no1;
                for (Film f2 : this.ratings.keySet()) {
                    if (f2.equals(o2)) {
                        int averageo2 = 0;
                        int no2 = 0;
                        for (Rating r2 : this.ratings.get(f2)) {
                            averageo2 += r2.getValue();
                            no2++;
                        }
                        averageo2 /= no2;
                        return averageo2 - averageo1;
                    }
                }
            }
        }
        return 0;
    }
    
}
