package Controller;

import Model.Movie;
import Model.MovieMap;
import com.google.gson.Gson;

import java.io.FileReader;
import java.util.List;

public class JsonReader {

    private Gson _gson;
    private FileReader _actualFile;

    public JsonReader(FileReader actualFile) {
        _gson = new Gson();
        _actualFile = actualFile;
    }

    //Movie movie = _gson.fromJson(new FileReader("D:\\file.json"), Movie.class);
    //Movie movie = _gson.fromJson(_actualFile, Movie.class);

    public MovieMap readObj(){
        return _gson.fromJson(_actualFile, MovieMap.class);
    }

    public MovieMap[] readArray(){
        return _gson.fromJson(_actualFile, MovieMap[].class);
    }

}

// 2. JSON to Java object, read it from a Json String.
//String jsonInString = "{'name' : 'mkyong'}";
//Movie movie = _gson.fromJson(jsonInString, Movie.class);

// JSON to JsonElement, convert to String later.
//JsonElement myJson = _gson.fromJson(new FileReader("D:\\file.json"), JsonElement.class);
//String result = _gson.toJson(myJson);
