package Controller;
import Model.Movie;
import Model.MovieMap;
import Model.Movies;
import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;

public class ReaderXML {

    private FileReader _actualFile;

    public ReaderXML(FileReader actualFile) {
        _actualFile = actualFile;
    }

    public MovieMap readObj() {
        MovieMap map;
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(MovieMap.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            map = (MovieMap) jaxbUnmarshaller.unmarshal(_actualFile);
        }catch (JAXBException e){
            e.printStackTrace();
            map = null;
        }

        return map;
    }

    public MovieMap[] readArray(){
        Movies maps;
        try{
            JAXBContext jaxbC = JAXBContext.newInstance(Movies.class);
            Unmarshaller jaxbUnmarshaller = jaxbC.createUnmarshaller();

            maps = (Movies) jaxbUnmarshaller.unmarshal(_actualFile);
        }catch (JAXBException e){
            e.printStackTrace();
            maps = null;
        }

        return maps.getMoviesmap();
    }


}
