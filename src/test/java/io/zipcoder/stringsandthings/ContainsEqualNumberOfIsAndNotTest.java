package io.zipcoder.stringsandthings;

import io.zipcoder.StringsAndThings;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author leon on 29/01/2019.
 */
public class ContainsEqualNumberOfIsAndNotTest {

    private StringsAndThings stringsAndThings;

    @Before
    public void setup(){
        stringsAndThings = new StringsAndThings();
    }

    @Test
    public void equalIsNotTest1(){
        Boolean actual = stringsAndThings.containsEqualNumberOfIsAndNot("This is not");
        // Assert.assertTrue(actual);
        // The assert in this exercise was wrong and I changed from True to False!!
        Assert.assertFalse(actual);
    }

    @Test
    public void equalIsNotTest2(){
        Boolean actual = stringsAndThings.containsEqualNumberOfIsAndNot("This is notnot");
        // Assert.assertFalse(actual);
        // The assert in this exercise was wrong and I changed from False to True!!
        Assert.assertTrue(actual);
    }

    @Test
    public void equalIsNotTest3(){
        Boolean actual = stringsAndThings.containsEqualNumberOfIsAndNot("noisxxnotyynotxisi");
        Assert.assertTrue(actual);
    }
}
