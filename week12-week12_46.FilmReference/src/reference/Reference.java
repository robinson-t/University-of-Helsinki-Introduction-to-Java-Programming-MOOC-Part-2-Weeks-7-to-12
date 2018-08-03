/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.*;

/**
 *
 * @author tomro
 */
public class Reference {
    private RatingRegister register;

    public Reference(RatingRegister register) {
        this.register = register;
    }
    
    public Film recommendFilm(Person person) {
        /*List<Film> films = new ArrayList<Film>();
        for (Film f : this.register.filmRatings().keySet()) {
        films.add(f);
        }
        Collections.sort(films, new FilmComparator(this.register.filmRatings()));
        return films.get(0);*/
        int highestCurrentSimilarity = 0;
        Person currentSuggester = null;
        for (Person p : this.register.reviewers()) {
            if (p.equals(person)) {
                continue;
            }
            int similarity = 0;
            for (Film f : this.register.getPersonalRatings(person).keySet()) {
                for (Film k : this.register.getPersonalRatings(p).keySet()) {
                    if (f.equals(k)) {
                        similarity += (register.getRating(person, f).getValue() * 
                                register.getRating(p, f).getValue());
                    }
                }
            }
            if (similarity > highestCurrentSimilarity) {
                highestCurrentSimilarity = similarity;
                currentSuggester = p;
            }
            
        }
        Film suggestion = null;
        List<Film> filmsTheyHaveSeen = new ArrayList<Film>();
        for (Film f : this.register.getPersonalRatings(person).keySet()) {
            filmsTheyHaveSeen.add(f);
        }
        if (filmsTheyHaveSeen.isEmpty()) {
            //previous code
            List<Film> films = new ArrayList<Film>();
            for (Film f : this.register.filmRatings().keySet()) {
                films.add(f);
            }
            Collections.sort(films, new FilmComparator(this.register.filmRatings()));
            return films.get(0);
        }
        
        if (currentSuggester == null) {
                return null;
            }
        
        for (Film f : this.register.getPersonalRatings(currentSuggester).keySet()) {
            if (filmsTheyHaveSeen.contains(f)) {
                continue;
            }
            if (this.register.getPersonalRatings(currentSuggester).get(f).equals(Rating.GOOD)) {
                return f;
            }
        }
        for (Film f : this.register.getPersonalRatings(currentSuggester).keySet()) {
            if (filmsTheyHaveSeen.contains(f)) {
                continue;
            }
            if (this.register.getPersonalRatings(currentSuggester).get(f).equals(Rating.FINE)) {
                return f;
            }
        }
        return null;
        
        
        
        
    }
    
}
