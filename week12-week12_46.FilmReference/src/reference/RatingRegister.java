/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author tomro
 */
public class RatingRegister {
    private Map<Film, List<Rating>> filmsAndRatings;
    private Map<Person, Map<Film, Rating>> personalRatings;

    public RatingRegister() {
        this.filmsAndRatings = new HashMap<Film, List<Rating>>();
        this.personalRatings = new HashMap<Person, Map<Film, Rating>>();
        
    }
    
    
    
    public void addRating(Film film, Rating rating) {
        int isIn = 0;
        for (Film f : this.filmsAndRatings.keySet()) {
            if (f.equals(film)) {
                this.filmsAndRatings.get(f).add(rating);
                isIn = 1;
            }
        }
        if (isIn == 0) {
            this.filmsAndRatings.put(film, new ArrayList<Rating>());
            for (Film f : this.filmsAndRatings.keySet()) {
                if (f.equals(film)) {
                    this.filmsAndRatings.get(f).add(rating);
                }
            }
        }
        
        
    }
    
    public void addRating (Person person, Film film, Rating rating) {
        int isIn = 0;
        for (Person p : this.personalRatings.keySet()) {
            if (p.equals(person)) {
                this.personalRatings.get(p).put(film, rating);
                isIn = 1;
                addRating(film, rating);
            }
        }
        if (isIn == 0) {
            this.personalRatings.put(person, new HashMap<Film, Rating>());
            for (Person p : this.personalRatings.keySet()) {
                if (p.equals(person)) {
                    this.personalRatings.get(p).put(film, rating);
                    addRating(film , rating);
                }
            }
            
        }
        
    }
    
    public Rating getRating(Person person, Film film) {
        for (Person p : this.personalRatings.keySet()) {
            if (p.equals(person)) {
                for (Film f : this.personalRatings.get(p).keySet()) {
                    if (f.equals(film)) {
                        return this.personalRatings.get(p).get(film);
                    }
                }
            }
        }
        return Rating.NOT_WATCHED;
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        for (Person p : this.personalRatings.keySet()) {
            if (p.equals(person)) {
                return this.personalRatings.get(p);
            }
            
        }
        return new HashMap<Film, Rating>();
    }
    
    public List<Person> reviewers() {
        List<Person> people = new ArrayList<Person>();
        for (Person p : this.personalRatings.keySet()) {
            people.add(p);
        }
        return people;
    }
    
    public List<Rating> getRatings(Film film) {
        for (Film f : this.filmsAndRatings.keySet()) {
            if (!f.equals(film)) {
                continue;
            }
            return this.filmsAndRatings.get(f);
        }
        return null;
        
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        return this.filmsAndRatings;
    }
    
    
}
