package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Movies {

    @XmlElement(name="movie")
    private MovieMap[] moviesmap;

    public void setMoviesmap(MovieMap[] moviesmap) {
        this.moviesmap = moviesmap;
    }
    public MovieMap[] getMoviesmap() {
        return moviesmap;
    }
}
