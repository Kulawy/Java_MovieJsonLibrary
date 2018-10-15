package View;

import Controller.MovieService;
import Model.Movie;
import Model.MovieMap;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private FileReader _file;
    private MovieMap _movieMap;
    private List<Movie> _movies;
    private Scanner _sc;
    private String _command;
    private String _path;
    private MovieService _mService;

    private final String INSTRUCTIONS =
            "\nNum:     Action:\n" +
            "01     upload file\n" +
            "02     convert form JSON file to Movie String Object\n" +
            "03     convert form XML file to Movie String Object\n" +
            "04     map String Object to Movie Object\n" +

            "97     add movie\n" +
            "98     init add one movie\n" +
            "99     init add Movies for table\n" +

            "21     Filter Object by gemre\n" +
            "22     search movie by actor\n" +
            "23     search movie by Year\n" +

            "31     print uploaded MovieMap\n" +
            "32     print uploaded Movie\n" +

            "exit           to exit";

    public UserInterface(){
        _sc = new Scanner(System.in);
        _mService = new MovieService();
        _movieMap = new MovieMap();
        System.out.println("Hello, Welcome on Json Service\nType your command and press enter");
        System.out.println(INSTRUCTIONS);
    }

    public void start(){
        _command = _sc.nextLine();
        System.out.println();
        while ( !_command.toLowerCase().equals("exit")){
            switch (_command){
                case "01":
                    setFilePath();
                    _mService.uploadFile();
                    break;
                case "02":
                    _mService.convertFromJsonToMovie();
                    break;
                case "04":
                    map();
                    break;
                case "96":
                    _mService.addMovie();
                    break;
                case "97":
                    setFilePath();
                    _mService.addMovies();
                    break;
                case "98":
                    _mService.initOnebyOne();
                    break;
                case "99":
                    _mService.initTableJson();
                    break;
                case "99x":
                    _mService.initTableXml();
                    break;
                case "21":
                    filter();
                    break;
                case "22":
                    searchByActor();
                    break;
                case "23":
                    searchByYearUI();
                    break;
                case "31":
                    printMovieMap();
                case "32":
                    printMovies();
                    break;
                default:
                    System.out.println("Bad command");
            }
            System.out.println(INSTRUCTIONS);
            _command = _sc.nextLine();
            System.out.println();
        }
    }

    private void map() {
        _movies = new ArrayList<>();
        _movies = _mService.get_movies();
        _movies.add(_movieMap.mapToMovie());
        _mService.set_movies(_movies);
    }

    public void searchByActor() {
        System.out.println("Type first name");
        String firstName = _sc.nextLine();
        System.out.println("Type last name");
        String lastName = _sc.nextLine();
        printMovies(_mService.searchByActor(firstName,lastName));
    }

    public void filter() {
        System.out.println("Type gemre:");
        String gS = _sc.nextLine();
        printMovies(_mService.filterByGenre(gS));
    }

    private void printMovieMap() {
        System.out.println(_movieMap+"\n");
    }

    private void printMovies() {
        for(Movie m: _mService.get_movies()){
            System.out.println(m+"\n");
        }
    }

    private void printMovies(List<Movie> movieList) {
        System.out.println();
        for(Movie m: movieList){
            System.out.println(m+"\n");
        }
    }

    private void setFilePath(){
        System.out.println("Set path to the file: ");
        _path = _sc.nextLine();
        _mService.set_path(_path);
    }

    private void searchByYearUI(){
        System.out.println("Set min Year in format: YYYY");
        int min = _sc.nextInt();
        System.out.println("Set max Year in format: YYYY");
        int max = _sc.nextInt();
        printMovies(_mService.searchByYear(min, max));
    }

}
