package View;


import Controller.FileReceiver;
import Controller.MovieService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {

    private static UserInterface ui;
    private static MovieService ms;
    private static FileReceiver fr;

    @BeforeAll
    public static void beforeAll(){
        ui = new UserInterface();
        ms = new MovieService();
        ms.initTableJson();
    }

    @Test
    public void startTest() {

    }


}