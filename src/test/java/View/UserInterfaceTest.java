package View;

import Controller.FileReceiver;
import Controller.MovieService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

public class UserInterfaceTest {

    protected static UserInterface _ui;

    @BeforeMethod
    public static void setUpEach(){
        _ui = new UserInterface();
        //ui.setFilePath("C:\\Users\\jgeron\\Desktop\\Sii\\MovieLibrary_lib\\movies.json");
        _ui.loadTableMoviesFromJson("src/main/resources/movies.json");
    }

    @Test
    public void shouldPrintTrue(){
        Assert.assertTrue(_ui.printMovies());
    }

    @Test
    public void shouldPrintString(){
        String outputS = "Title: Venom\n" +
                "Date: Fri Oct 05 00:00:00 CEST 2018\n" +
                "Runetime: 112 min\n" +
                "Director: Ruben Fleischer\n" +
                "Title: Thor\n" +
                "Date: Fri May 06 00:00:00 CEST 2011\n" +
                "Runetime: 115 min\n" +
                "Director: Kenneth Branagh\n";
        Assert.assertEquals(_ui.printMoviesS(), outputS);
    }

    @AfterClass
    public void tearDownAll(){
        _ui = null;
    }


}