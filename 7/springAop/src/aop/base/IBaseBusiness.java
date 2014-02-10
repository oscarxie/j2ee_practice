package aop.base;
public interface IBaseBusiness {

    /**
     * 用作代理的切入点方法
     * 
     * @param obj
     * @return
     */
    public String delete(String obj);

    /**
     * 这方法不被切面切
     * 
     * @param obj
     * @return
     */
    public String add(String obj);

    /**
     * 这方法切不切呢？可以设置
     * 
     * @param obj
     * @return
     */
    public String modify(String obj);

}