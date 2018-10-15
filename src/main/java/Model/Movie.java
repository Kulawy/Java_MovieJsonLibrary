package Model;

import java.util.Date;
import java.util.List;

public class Movie {

    private String _title;
    private Date _relased;
    private int _runtime;
    private Person _director;
    private int _year;

    public int getYear() {
        return _year;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public Date get_relased() {
        return _relased;
    }

    public void set_relased(Date _relased) {
        this._relased = _relased;
    }

    public int get_runtime() {
        return _runtime;
    }

    public void set_runtime(int _runtime) {
        this._runtime = _runtime;
    }

    public Person get_director() {
        return _director;
    }

    public void set_director(Person _director) {
        this._director = _director;
    }

    public List<String> get_genre() {
        return _genre;
    }

    public void set_genre(List<String> _genre) {
        this._genre = _genre;
    }

    public List<Person> get_actors() {
        return _actors;
    }

    public void set_actors(List<Person> _actors) {
        this._actors = _actors;
    }

    private List<String> _genre;
    private List<Person> _actors;

    public Movie(String _title, Date _relased, int _runtime, Person _director, List<String> _genre, List<Person> _actors, int year) {
        this._title = _title;
        this._relased = _relased;
        this._runtime = _runtime;
        this._director = _director;
        this._genre = _genre;
        this._actors = _actors;
        this._year = year;
    }

    @Override
    public String toString() {
        return "Title: " + _title +
                "\nDate: " + _relased.toString() +
                "\nRunetime: " + _runtime + " min" +
                "\nDirector: " + _director.toString();
    }

}
