package Controller;

import Model.Movie;
import Model.MovieMap;
import Model.Person;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private String _path;
    private FileReader _file;
    private MovieMap _movieMap;
    private MovieMap[] _movieMapArray;
    private List<Movie> _movies = new ArrayList<>();

    public String get_path() {
        return _path;
    }

    public void set_path(String _path) {
        this._path = _path;
    }

    public List<Movie> get_movies() {
        return _movies;
    }

    public void set_movies(List<Movie> _movies) {
        this._movies = _movies;
    }

    public void addMovies(){
        //_path = path;
        uploadFile();
        convertFromJsonToMovieMapTable();
        for (int i=0; i < _movieMapArray.length; i++){
            _movies.add(_movieMapArray[i].mapToMovie());
        }
    }

    public Movie[] mapToMovieArray(MovieMap[] _mmapArray){
        Movie[] ma = new Movie[_mmapArray.length];
        for (int i=0; i < ma.length; i++) {
            ma[i] = _mmapArray[i].mapToMovie();
        }
        return ma;
    }

    public void initOnebyOne(){
        //_path = "C:\\Users\\jgeron\\Desktop\\Sii\\MovieLibrary_lib\\venom.json";
        _path = "src/main/resources/venom.json";
        uploadFile();
        convertFromJsonToMovie();
        _movies.add(_movieMap.mapToMovie());
        //_path = "C:\\Users\\jgeron\\Desktop\\Sii\\MovieLibrary_lib\\thor.json";
        _path = "src/main/resources/thor.json";
        uploadFile();
        convertFromJsonToMovie();
        _movies.add(_movieMap.mapToMovie());
    }

    public void initTableJson(){
        //_path = "C:\\Users\\jgeron\\Documents\\JavaProjects2018\\FirstApp\\src\\main\\resources\\movies.json";
        _path = "src/main/resources/movies.json";
        uploadFile();
        convertFromJsonToMovieMapTable();

        for (int i=0; i < _movieMapArray.length; i++){
            _movies.add(_movieMapArray[i].mapToMovie());
        }
    }

    public void initTableXml(){
        _path = "src/main/resources/moviesX.xml";
        uploadFile();
        convertFromXmlToMovieMapTable();

        for (int i=0; i < _movieMapArray.length; i++){
            _movies.add(_movieMapArray[i].mapToMovie());
        }
    }



    public void uploadFile(){
        FileReceiver receiver = new FileReceiver();
        receiver.setFile(_path);
        _file = receiver.getFile();
        if (_file == null )
            System.out.println("nie tedy droga mlody padawanie\n\n");
    }

    public void convertFromJsonToMovie(){
        JsonReader jR = new JsonReader(_file);
        _movieMap = jR.readObj();
    }

    public void convertFromJsonToMovieMapTable(){
        JsonReader jR = new JsonReader(_file);
        _movieMapArray = jR.readArray();
    }

    private void convertFromXmlToMovieMapTable() {
        ReaderXML rXml = new ReaderXML(_file);
        _movieMapArray = rXml.readArray();
    }

    public void addMovie() {
        uploadFile();
        convertFromJsonToMovie();
        _movies.add(_movieMap.mapToMovie());
        System.out.println(_movieMap + "\n Movie Added");
    }

    public ArrayList<Movie> searchByYear(int min, int max){
        ArrayList<Movie> searchedMovies = new ArrayList<Movie>();
        for(Movie m: _movies){
            if ( m.getYear() >= min && m.getYear() <= max)
                searchedMovies.add(m);
        }
        return searchedMovies;
    }

    public ArrayList<Movie> searchByActor(String firstName, String lastName){
        ArrayList<Movie> moviesThatContains = new ArrayList<>();
        Person sa = new Person(firstName, lastName);
        for( Movie m: _movies){
            for( Person p: m.get_actors()){
                if ( p.equals(sa))
                    moviesThatContains.add(m);
            }
        }
        return moviesThatContains;
    }

    public ArrayList<Movie> filterByGenre(String gS){
        ArrayList<Movie> moviesThatContains = new ArrayList<>();
        for (Movie m: _movies) {
            for(String g: m.get_genre()){
                if ( g.toLowerCase().equals(gS.toLowerCase()))
                    moviesThatContains.add(m);
            }
        }
        return moviesThatContains;
    }

}
