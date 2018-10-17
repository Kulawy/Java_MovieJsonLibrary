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
    private int _command;
    private String _path;
    private MovieService _mService;


    public UserInterface() {
        _sc = new Scanner(System.in);
        _mService = new MovieService();
        _movieMap = new MovieMap();
        System.out.println("Hello, Welcome on Json Service\nType your command and press enter");

    }

    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            printOptions();
            System.out.println();
            switch (InterfaceOptions.createOption(_sc.nextInt())) {
                case EXIT:
                    isRunning = false;
                    break;
                case LOAD_ONE_MOVIE:
                    loadOneMovie();
                    break;
                case LOAD_TABLE_JSON:
                    loadTableMoviesFromJson(setFilePath());
                    break;
                case LOAD_XML_MOVIE:
                    //setFilePath();
                    _path = "src/main/resources/moviesX.xml";
                    _mService.set_path(_path);
                    _mService.addMoviesFromXML();
                    break;
                case FIND_BY_ACTOR:
                    searchByActor();
                    break;
                case FIND_BY_GENRE:
                    filterByGemre();
                    break;
                case FIND_BY_DATE_RANGE:
                    searchByYearUI();
                    break;
                case SHOW_ALL:
                    printMovies();
                    break;
                default:
                    System.out.println("Bad command\n");
            }
        }
    }

    public MovieService get_mService() {
        return _mService;
    }

    public void loadTableMoviesFromJson(String myPath) {
        //setFilePath();
        //_path = "src/main/resources/movies.json";
        //_mService.set_path(_path);
        _mService.set_path(myPath);
        _mService.addMoviesFromJson();
    }

    public void loadOneMovie() {
        //setFilePath();
        _path = "src/main/resources/thor.json";
        _mService.set_path(_path);
        _mService.convertFromJsonToMovie();
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
        printMovies(_mService.searchByActor(firstName, lastName));
    }

    public void filterByGemre() {
        System.out.println("Type gemre:");
        String gS = _sc.nextLine();
        printMovies(_mService.filterByGenre(gS));
    }

    private void printMovieMap() {
        System.out.println(_movieMap + "\n");
    }

    public boolean printMovies() {
        if (_mService.get_movies().isEmpty()) {
            System.out.println("Empty base");
            return false;
        } else {
            for (Movie m : _mService.get_movies()) {
                System.out.println(m + "\n");
            }
            return true;
        }
    }

    public String printMoviesS() {
        String result = "";
        if (_mService.get_movies().isEmpty()) {
            return "Empty";
        } else {
            for (Movie m : _mService.get_movies()) {
                result += m.toString() + "\n";
            }
            return result;
        }
    }

    public boolean printMovies(List<Movie> movieList) {
        if (movieList.isEmpty()) {
            System.out.println("No film added");
            return false;
        } else {
            System.out.println();
            for (Movie m : movieList) {
                System.out.println(m + "\n");
            }
            return true;
        }
    }

    private void printOptions() {
        for (InterfaceOptions o : InterfaceOptions.values()) {
            if (o.getName() != "BAD_COMMAND")
                System.out.println(o);
        }
    }

    public String setFilePath() {
        System.out.println("Write path to the file: (eg. C:\\Users\\jgeron\\Desktop\\Sii\\MovieLibrary_lib\\movies.json)");
        _sc = new Scanner(System.in);
        String myPath = _sc.nextLine();
        System.out.println(myPath + "\n");
        return myPath;
    }

    public String setFilePath(String filePath) {
        System.out.println(filePath + "\n");
        return filePath;
    }

    private void searchByYearUI() {
        System.out.println("Set min Year in format: YYYY");
        int min = _sc.nextInt();
        System.out.println("Set max Year in format: YYYY");
        int max = _sc.nextInt();
        printMovies(_mService.searchByYear(min, max));
    }

}


/*
private final String INSTRUCTIONS =
            "\nNum:     Action:\n" +
            "01     upload file\n" +
            "02     convert form JSON file to Movie String Object\n" +
            "03     convert form XML file to Movie String Object\n" +
            "04     map String Object to Movie Object\n" +

            "97     add movie\n" +
            "98     init add one movie\n" +
            "99     init add Movies for table\n" +
            "99x    init add Movies for table\n" +

            "21     Filter Object by gemre\n" +
            "22     search movie by actor\n" +
            "23     search movie by Year\n" +

            "31     print uploaded MovieMap\n" +
            "32     print uploaded Movie\n" +

            "exit           to exit";

public void start(){
        _command = _sc.nextInt();
        System.out.println();
        while ( _command != 0 ){
            switch (InterfaceOptions.createOption(_command)){
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
 */