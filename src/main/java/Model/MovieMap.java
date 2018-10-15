package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class MovieMap {

    private String title;
    private String released;
    private int runtime;
    private String director;
    private List<String> genres;
    private List<String> actors;

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
        String yearS = released.substring(6);
        int year = Integer.parseInt(yearS);
        return new Movie(title, rel, runtime, stringToPerson(director), getGenreList(), getActorsList(), year );
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
