package order;

import components.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import payment.Card;
import person.Customer;
import person.Employee;

import java.util.ArrayList;
import java.util.List;

public class ComputerRepairService implements IRetrieveFromList {
    static List<Order> orderList = new ArrayList<>();
    static List<Customer> customerList = new ArrayList<>();
    static List<Employee> employeeList = new ArrayList<>();
    static List<Component> componentList = new ArrayList<>();
    static List<Card> cardList = new ArrayList<>();
    static int orderAmount = 0;
    private static final Logger LOGGER = LogManager.getLogger("Computer Repair Service Log");
    // Add orders, customers, employees
    public static void addOrder(Order order) {
        orderList.add(order);
    }
    public static void increaseOrderAmount(){ orderAmount += 1; }
    public static void decreaseOrderAmount(){ orderAmount -= 1; }
    public static void addCustomer(Customer customer) { customerList.add(customer); }
    public static void addEmployee(Employee employee) { employeeList.add(employee); }
    public static void addCard(Card card){cardList.add(card);}
    // Show Lists
    public static void showOrderList() {
        System.out.println("Order List: ");
        for(int i = 0; i < orderList.size(); i++){
            //System.out.println(orderList.get(i));
            LOGGER.info(orderList.get(i));
            // Make it like table, use toString
        }
    }
    public static void showEmployeeList() {
        System.out.println("Employee List: ");
        for(int i = 0; i < employeeList.size(); i++){
            System.out.println(employeeList.get(i));
            LOGGER.info(employeeList.get(i));
            // Make it like table, use toString
        }
    }
    public static void showCardList() {
        System.out.println("Employee List: ");
        for(int i = 0; i < cardList.size(); i++){
            System.out.println(cardList.get(i));
            LOGGER.info(cardList.get(i));
            // Make it like table, use toString
        }
    }

    // Remove From ArrayLists:
    public static void removeFromOrderList(int orderNumber) { orderList.remove(orderNumber); }
    public static void removeFromEmployeeList(int employeeId){ employeeList.remove(employeeId);}
    public static void removeCard(int orderNumber){cardList.remove(orderNumber);}
//
    public static Order getOrder(int orderNumber){
        return orderList.get(orderNumber);
    }


    public static int getOrderAmount() {
        return orderAmount;
    }

    @Override
    public Card retrieveCard(int orderNumber) {
        return cardList.get(orderNumber);
    }

    @Override
    public List<Employee> retrieveEmployeeList() {
        return employeeList;
    }
}
