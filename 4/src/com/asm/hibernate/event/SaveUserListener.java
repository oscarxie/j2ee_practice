package com.asm.hibernate.event;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;

import com.asm.hibernate.domain.User;

public class SaveUserListener extends DefaultSaveOrUpdateEventListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6964127086976708335L;

	public void onSaveOrUpdate(SaveOrUpdateEvent event)
			throws HibernateException {
		if (event.getObject() instanceof com.asm.hibernate.domain.User) {
			User user = (User) event.getObject();
			System.out.println("find save User:" + user.getName());
		//	user.setDate(new Date());
		}
		super.onSaveOrUpdate(event);
	}
}
