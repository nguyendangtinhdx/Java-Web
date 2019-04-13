package hoa.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Myinterceptor extends AbstractInterceptor  {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		Map<String, Object> session = ai.getInvocationContext().getSession();
		String login = (String) session.get("login");
		if(login==null) {
			return Action.LOGIN;
		}
		return ai.invoke();
	}
	
}
