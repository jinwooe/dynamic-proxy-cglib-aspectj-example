package dynamic_proxy;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NoOpAddInvocationHandlerTest {
	private List<Object> list;
	
	private List<Object> proxy;
	
	@Before
	public void setUp() {
		list = new ArrayList<Object>(0);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testInvoke() {
		
		proxy = (List<Object>) Proxy.newProxyInstance(NoOpAddInvocationHandlerTest.class.getClassLoader(),
				new Class[] {List.class}, new NoOpAddInvocationHandler<Object>(list));
		
		assertTrue(proxy instanceof Proxy);
	}
	
	public void testAdd() {
		proxy.add(new Object());
		
		assertTrue(list.isEmpty());
	}
}
