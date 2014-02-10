package com.javatrian.struts2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		ActionContext ctx = actionInvocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ctx
				.get(ServletActionContext.HTTP_RESPONSE);

		HttpSession session = request.getSession();
		System.out.println();
		String actionName = actionInvocation.getProxy().getActionName();
		if (actionName != null && !"".equals(actionName.trim())) {
			if (actionName.indexOf("/") > 0)
				actionName = actionName.substring(actionName.indexOf("/") + 1);
		}

		if (!"login".equals(actionName) && !"logout".equals(actionName)
				&& session.getAttribute(LoginAction.LOGIN_SESSION_KEY) == null) {
			response.sendRedirect("login.do");
			return null;
		}

		return actionInvocation.invoke();
	}
}
