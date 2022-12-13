package order;

import components.Component;
import person.Customer;
import person.Employee;

import java.util.ArrayList;

public interface IMakeOrder {
     void makeOrder(int orderNumber, Customer customer, Employee employee, ArrayList<Component> componentList);
}
