
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by supervisor on 08.09.2016.
 */
public class CounterTest {

    private static int[] zero = {};
    private static int[] arraywith6 = {6};
    private static int[] arrayfewnumb = {1,5,7,8,7,5,7};
    private static int value = 6;
    private static int value1 = 7;
    private static Counter c;

    @BeforeClass
    public static  void start()
    {
        c = new Counter();
    }

    @Test
    public void isValueZero()
    {
        boolean check =c.isValue(zero, value);
        Assert.assertEquals(false, check);
    }

    @Test
    public void isValueTrueOne()
    {
        boolean check =c.isValue(arraywith6, value);
        Assert.assertEquals(true, check);
    }

    @Test
    public void isValueTrueFew()
    {
        boolean check =c.isValue(arrayfewnumb, value1);
        Assert.assertEquals(true, check);
    }

    @Test
    public void countZeroSizedArray() throws Exception {
        //final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(outContent));
        int cc = c.countElem(value, zero);
        Assert.assertEquals(0, cc);
        //assertEquals("Wrong array size!", outContent.toString());
        //outContent.reset();
    }

    @Test
    public void countNoElemInArray()
    {
        final ByteArrayOutputStream outContent1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent1));
        int cc = c.countElem(value, arrayfewnumb);
        Assert.assertEquals(0, cc);
        assertEquals("No element in array!", outContent1.toString());
    }

    @Test
    public void countRightFewElem()
    {
        int cc = c.countElem(value1, arrayfewnumb);
        Assert.assertEquals(3, cc);
    }

    @Test
    public void countRightOneElem()
    {
        int cc = c.countElem(value, arraywith6);
        Assert.assertEquals(1, cc);
    }

    @Test
    public void getIndexZero()
    {
        int[] index = c.getInts(zero, value, 0);
        int[] res = {};
        Assert.assertArrayEquals(res, index);
    }

    @Test
    public void getIndexOneElem()
    {
        int[] index = c.getInts(arraywith6, value, 1);
        int[] res = {0};
        Assert.assertArrayEquals(res, index);
    }

    @Test
    public void getIndexFewElem()
    {
        int[] index = c.getInts(arrayfewnumb, value1, 3);
        int[] res = {2,4,6};
        Assert.assertArrayEquals(res, index);
    }
}