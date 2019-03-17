import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testRemoveHoratio() {
        String test = "Hello Howdy Horatio HORATIO";
        String actual = hamletParser.removeHoratio(test);
        String expected = "Hello Howdy Leon Leon";
        Assert.assertEquals(expected,actual);


    }

    @Test
    public void testRemoveHamlet() {
        String test = "Hamlet Howdy Hamlet HORATIO";
        String actual = hamletParser.removeHamlet(test);
        String expected = "Tariq Howdy Tariq HORATIO";
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testRemoveHoratioAndHamlet(){
        String test = "Horatio Hamlet Horatio Hamlet HashBrowns Hula HulaSkirt Horation";
        String actual = hamletParser.removeHoratioAndHamlet(test);
        String expected = "Leon Tariq Leon Tariq HashBrowns Hula HulaSkirt Horation";

    }
}