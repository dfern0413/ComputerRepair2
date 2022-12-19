package order;


import components.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import person.Customer;
import person.Employee;

import java.util.ArrayList;

public class Order implements ICalculateCost, IMakeOrder{
    int orderNumber;
    private ArrayList<Component> componentList = new ArrayList<Component>();
    Customer customer;
    Employee employee;
    Component component;
    private static final Logger LOGGER = LogManager.getLogger("Order Log");

//    public Order(int orderNumber, Customer customer, Employee employee, ArrayList<Component> componentList ) {
////        try {
//        this.orderNumber = orderNumber;
//        this.customer = customer;
//        this.employee = employee;
//        this.componentList = componentList;
//        }
    public ArrayList<Component> getComponentList(){
        return componentList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", customer=" + customer +
                ", employee=" + employee +
                ", component=" + component +
                '}';
    }
    public int repairPartCost() {
        int totalCost = 0;
        for(int i = 0; i < componentList.size(); i++) {
            if (componentList.get(i).getName().equals("Cpu")) {
                Cpu holder = (Cpu) componentList.get(i);
                int partCost = holder.getCpuCost();
                totalCost += partCost;
            } else if (componentList.get(i).getName().equals("Keyboard")) {
                Keyboard holder = (Keyboard) componentList.get(i);
                int partCost = holder.getKeyboardCost();
                totalCost += partCost;
            } else if (componentList.get(i).getName().equals("Motherboard")) {
                Motherboard holder = (Motherboard) componentList.get(i);
                int partCost = holder.getMotherboardCost();
                totalCost += partCost;
            } else if (componentList.get(i).getName().equals("Ram")) {
                Ram holder = (Ram) componentList.get(i);
                int partCost = holder.getRamCost();
                totalCost += partCost;
            } else if (componentList.get(i).getName().equals("Storage")) {
                Storage holder = (Storage) componentList.get(i);
                int partCost = holder.getStorageCost();
                totalCost += partCost;
            }
        }
        return totalCost;
    }

    @Override
    public void makeOrder(int orderNumber, Customer customer, Employee employee, ArrayList<Component> componentList) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.employee = employee;
        this.componentList = componentList;

    }
}
