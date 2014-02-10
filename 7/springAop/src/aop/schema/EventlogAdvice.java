package aop.schema;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.core.Ordered;

public class EventlogAdvice implements Ordered {

	private int order = 1;

	//private EventLogService service;

	public Object serviceIntercept(ProceedingJoinPoint point) throws Throwable {
		if (point instanceof MethodInvocationProceedingJoinPoint) {
			MethodInvocationProceedingJoinPoint mpoint = (MethodInvocationProceedingJoinPoint) point;
			//
		}
		try {
			System.out.println("记录日志开始");
			//service.eventLog();
			System.out.println("staring event log action here");
			System.out.println("记录日志结束");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

//	public EventLogService getService() {
//		return service;
//	}
//
//	public void setService(EventLogService service) {
//		this.service = service;
//	}
}