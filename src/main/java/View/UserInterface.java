package View;

import Controller.FileReceiver;
import Controller.JsonReader;
import Controller.MovieService;
import Model.Genre;
import Model.Movie;
import Model.MovieMap;
import Model.Person;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private FileReader _file;
    private MovieMap _movieMap;
    private List<Movie> _movies = new ArrayList<>();
    private Scanner _sc;
    private String _command;
    private String _path;
    private MovieService _mService;

    private final String INSTRUCTIONS = "Key:           Action:\n" +
            "l              upload file\n" +
            "init one       set all work for one movie\n" +
            "init table     set all work for table\n" +
            "cjm            convert form JSON file to Movie String Object\n" +
            "cxm            convert form XML file to Movie String Object\n" +
            "map            map String Object to Movie Object\n" +
            "filter         Filter Object by gemre\n" +
            "search         search movie by actor\n" +
            "pmm            print uploaded MovieMap\n" +
            "pm             print uploaded Movie\n" +
            "add            to add whole movie\n" +
            "exit           to exit";

    public UserInterface(){
        _mService = new MovieService();
        _sc = new Scanner(System.in);
        System.out.println("Hello, Welcome on Json Service\nType your command and press enter");
        System.out.println(INSTRUCTIONS);
    }

    public void start(){
        _command = _sc.nextLine();
        System.out.println();
        while ( !_command.toLowerCase().equals("exit")){
            switch (_command){
                case "add":
                    _mService.addMovie();
                    break;
                case "init one":
                    _mService.initOnebyOne();
                    break;
                case "init table":
                    _mService.initTable();
                    break;
                case "l":
                    setFilePath();
                    _mService.uploadFile();
                    break;
                case "cjm":
                    _mService.convertFromJsonToMovie();
                    break;
                case "pmm":
                    printMovieMap();
                case "pm":
                    printMovie();
                    break;
                case "map":
                    _movies.add(_movieMap.mapToMovie());
                    break;
                case "filter":
                    filter();
                    break;
                case "search":
                    search();
                    break;
                default:
                    System.out.println("Bad command");
            }
            System.out.println(INSTRUCTIONS);
            _command = _sc.nextLine();
            System.out.println();
        }
    }

    public void search() {
        System.out.println("Type first name");
        String firstName = _sc.nextLine();
        System.out.println("Type last name");
        String lastName = _sc.nextLine();
        List<Movie> moviesThatContains = new ArrayList<>();
        Person sa = new Person(firstName, lastName);
        for( Movie m: _movies){
            for( Person p: m.get_actors()){
                if ( p.equals(sa))
                    moviesThatContains.add(m);
            }
        }
        System.out.println(moviesThatContains);
    }

    public void filter() {
        System.out.println("Type gemre:");
        String gS = _sc.nextLine();
        List<Movie> moviesThatContains = new ArrayList<>();
        for (Movie m: _movies) {
            for(String g: m.get_genre()){
                if ( g.toLowerCase().equals(gS.toLowerCase()))
                    moviesThatContains.add(m);
            }
        }
        System.out.println(moviesThatContains);
    }

    private void printMovieMap() {
        System.out.println(_movieMap+"\n");
    }

    private void printMovie() {
        for(Movie m: _movies){
            System.out.println(m+"\n");
        };
    }

    private void setFilePath(){
        System.out.println("Set path to the file: ");
        _path = _sc.nextLine();
        _mService.set_path(_path);
    }

}
