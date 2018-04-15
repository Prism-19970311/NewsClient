package com.prism.newsclient_project_1;

import com.prism.newsclient_project_1.properties.AppProperties;
import com.prism.newsclient_project_1.sourceOP.HttpStreamOP;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testGetinputstream() {
        InputStream in = new HttpStreamOP().getinputstream(AppProperties.SERVERPATH);

        if(in !=null) {
            System.out.print("66666666666666666666666666666666666666666666666666666666666666666");
        }
    }
}