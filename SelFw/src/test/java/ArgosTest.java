import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collection;
 
public class ArgosTest {
 
    private Collection collection;
 
    @BeforeClass
    public void oneTimeSetUp() {
        // one-time initialization code   
    	System.out.println("@BeforeClass - oneTimeSetUp");
    }
 
    @AfterClass
    public void oneTimeTearDown() {
        // one-time cleanup code
    	System.out.println("@AfterClass - oneTimeTearDown");
    }
 
    @BeforeMethod
    public void setUp() {
        collection = new ArrayList();
        System.out.println("@BeforeMethod - setUp");
    }
 
    @AfterMethod
    public void tearDown() {
        collection.clear();
        System.out.println("@AfterMethod - tearDown");
    }
 
    @Test
    public void testEmptyCollection() {
        Assert.assertEquals(collection.isEmpty(),true);
        System.out.println("@Test - testEmptyCollection");
    }
    
    @Test
    public void testSomething() {
    	Assert.assertEquals(4, (2 * 2));
    }
    
    
 
    @Test
    public void testOneItemCollection() {
        collection.add("itemA");
        Assert.assertEquals(collection.size(),1);
        System.out.println("@Test - testOneItemCollection");
    }
}