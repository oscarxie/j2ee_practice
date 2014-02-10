package wintys.struts2.i18n;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Winty (wintys@gmail.com)
 * @version 2009-8-9
 * @see http://wintys.blogjava.net
 */
public class I18nAction extends ActionSupport {
	private static final long serialVersionUID = 2188344424923390101L;
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
		
	@Override
	public void validate() {
		if(name == null || "".equals(name.trim()) ){
			//before i18n
			//addActionError("name should not be empty");
			
			//after i18n
			//带参数也可以:getText(String key , String[] args);
			addActionError(getText("wintys.i18n.name.invalid"));
		}
	}
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}

}
