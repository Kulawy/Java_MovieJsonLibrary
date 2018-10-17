import View.UserInterface;
import View.UserInterfaceTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovieServiceTests extends UserInterfaceTest {

    @Test
    public void shouldMovieCountBeEqual(){
        Assert.assertEquals(_ui.get_mService().get_movies().size(), 2);
    }


}
