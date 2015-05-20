package cglib;

import static org.junit.Assert.*;
import net.sf.cglib.proxy.Enhancer;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the use of CGLib.
 * 
 * @author <a href="http://blog.frankel.ch/">Nicolas Frankel</a>
 */
public class HashCodeAlwaysZeroMethodInterceptorTest {

    /** Proxy object. */
    private Object proxy;

    /**
     * Creates the proxy to test.
     */
    @Before
    public void setUp() {

        proxy = Enhancer.create(Object.class, new HashCodeAlwaysZeroMethodInterceptor());
    }

    /**
     * Tests {@link Object#equals(Object)}.
     */
    @Test
    public void testEquals() {

        assertFalse(proxy.equals(new Object()));
    }

    /**
     * Tests {@link Object#hashCode()}.
     */
    @Test
    public void testHashCode() {

        assertEquals(proxy.hashCode(), 0);
    }
}
