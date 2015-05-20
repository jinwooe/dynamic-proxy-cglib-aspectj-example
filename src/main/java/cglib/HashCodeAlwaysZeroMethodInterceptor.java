package cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Specific method interceptor for {@link Object#hashCode()}.
 * 
 * @author <a href="http://blog.frankel.ch/">Nicolas Frankel</a>
 */
public class HashCodeAlwaysZeroMethodInterceptor implements MethodInterceptor {

	/**
	 * For {@link Object#hashCode()}, always returns <code>0</code>.
	 * Otherwise, does what is expected.
	 * 
	 * @see net.sf.cglib.proxy.MethodInterceptor#intercept(Object, Method,
	 *      Object[], MethodProxy)
	 */
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

		if ("hashCode".equals(method.getName())) {

			return 0;
		}

		return methodProxy.invokeSuper(object, args);
	}
}
