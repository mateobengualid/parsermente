/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import parsers.sax.SAXParser;

/**
 *
 * @author mateo
 */
public class TestDeSAXParser
{
    public TestDeSAXParser()
    {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void hello() throws IOException
    {
        System.out.println(new File(".").getAbsolutePath());
        InputStreamReader fis = new FileReader("./test/otro.xml");
        TestHandler handler = new TestHandler();
        SAXParser parser = new SAXParser(handler);
        parser.parse(fis);
    }
}