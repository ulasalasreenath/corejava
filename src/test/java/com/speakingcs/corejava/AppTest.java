package org.speakingcs.corejava;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit org.speakingcs.corejava.test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the org.speakingcs.corejava.test case
     *
     * @param testName name of the org.speakingcs.corejava.test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
