package mypack;
import java.io.Serializable;

public class Order implements Serializable {

    private Long id;

    private String orderNumber;

    private mypack.Customer customer;

    public Order(String orderNumber, mypack.Customer customer) {
        this.orderNumber = orderNumber;
        this.customer = customer;
    }

    public Order() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public mypack.Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(mypack.Customer customer) {
        this.customer = customer;
    }
}







/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<精通Hibernate：Java对象持久化技术详解>>  *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
