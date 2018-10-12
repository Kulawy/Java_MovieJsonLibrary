package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieMap {

    private String title;
    private String released;
    private int runtime;
    private String director;
    private List<String> genres;
    private List<String> actors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                "\nDate: " + released +
                "\nRunetime: " + runtime + " min" +
                "\nDirector: " + director +
                "\nGenre: " + genres +
                "\nActors: " + actors ;
    }

    //NO TO JEDZIEMY ZE ZWYKLEGO STRINGA NA MOVIE OBIEKT
    public Movie mapToMovie(){

        Date rel;
        try {
            rel = new SimpleDateFormat("dd/MM/yyyy").parse(released);
        } catch (ParseException e) {
            e.printStackTrace();
            rel = null;
        }
        return new Movie(title, rel, runtime, stringToPerson(director), getGenreList(), getActorsList()  );
    }

    private List<String> getGenreList() {
        List<String> gn = new ArrayList<>();
        for (String genreString: genres) {
            gn.add(genreString);
        }
        return gn;
    }

    private Person stringToPerson(String director) {
        String[] name = director.split(" ");
        String firstName = name[0];
        String lastName = name[1];
        return new Person(firstName, lastName);
    }

    private List<Person> getActorsList(){

        List<Person> act = new ArrayList<>();
        for (String actor: actors) {
            String[] name = actor.split(" ");
            act.add(new Person(name[0], name[1]));
        }
        return act;
    }


}
