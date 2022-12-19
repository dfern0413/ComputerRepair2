
import components.*;
import exception.*;
import order.ComputerRepairService;

import order.Order;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import payment.Card;
import person.Customer;
import person.Employee;

import java.util.ArrayList;
import java.util.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InvalidNameException, InvalidEmailException, InvalidComponentException, InvalidMenuOptionException {
        //Employees starting list
        Employee employee1 = new Employee("Frank Gomez", 0);
        ComputerRepairService.addEmployee(employee1);
        Employee employee2 = new Employee("Henry Lopez", 1);
        ComputerRepairService.addEmployee(employee2);

        printOptions();
        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            option = scanner.next();
            makeAChoice(option);
        } while (!option.equals("0"));
    }

    private static void printOptions() {
        LOGGER.info("Please choose one of the following options");
        LOGGER.info("1 - For customer");
        LOGGER.info("2 - For employee");
        LOGGER.info("3 - For management");
        LOGGER.info("0 - To exit");
    }

    private static void makeAChoice(String choice) throws InvalidNameException, InvalidEmailException, InvalidComponentException, InvalidMenuOptionException {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case "0":
                LOGGER.info("Have a nice day");
                break;
            case "1":
                printCustomerOptions();
                makeCustomerChoice(scanner.next());
                continueOperation();
                break;

            case "2":
                printEmployeeOptions();
                makeEmployeeChoice(scanner.next());
                continueOperation();
                break;
            case "3":
                printManagementOptions();
                makeManagementChoice(scanner.next());
                continueOperation();
                break;
            default:
                printOptions();

        }
    }

    private static void printCustomerOptions() {
        LOGGER.info("1 - Make an order");
        LOGGER.info("2 - Check order balance");
        LOGGER.info("3 - Check Payment information");
        LOGGER.info("9 - To main page");
    }

    private static void makeCustomerChoice(String option) throws InvalidNameException, InvalidEmailException, InvalidComponentException, InvalidMenuOptionException {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case "1":
                String customerName;
                try {
                    LOGGER.info("Please insert your name");
                    customerName = scanner.nextLine();
                    if (customerName.isEmpty()) {
                        throw new InvalidNameException("Error: Incorrect name input");
                    }
                } catch (InvalidNameException e) {
                    LOGGER.info("Error: Incorrect name input");
                    break;
                }

                LOGGER.info("Please insert your email");
                String customerEmail = scanner.nextLine();

                //Make customer class
                Customer customerCreated = new Customer(customerName, customerEmail);

                LOGGER.info("Please select an employee and their Id from the list");

                ComputerRepairService.showEmployeeList();
                String employeeName = scanner.nextLine();


//                ComputerRepairService.showEmployeeList();
//                String employeeName = scanner.nextLine();
                int employeeId = Integer.parseInt(scanner.nextLine());
                try{
                    Employee employeeAssigned = new Employee(employeeName, employeeId);
                    ComputerRepairService computerRepairService = new ComputerRepairService();
                    List<Employee> employeeList = computerRepairService.retrieveEmployeeList();
                    LOGGER.info(employeeList.get(1));
                    for(int i = 0; i < employeeList.size(); i++){
                        employeeList.get(i);
                    }
                    if(employeeList.contains(new Employee(employeeName, employeeId))){
                        LOGGER.info("Found");
                    }
                    else {
                        throw new InvalidEmployeeSelectedException("Error: Invalid Employee Assigned");
                    }
                }catch (InvalidEmployeeSelectedException e){
                    LOGGER.info("Error: Invalid Employee Selected");
                    break;
                }
                Employee employeeAssigned = new Employee(employeeName, employeeId);

                // Add an option to pick how many components and then for loop
                LOGGER.info("How many components are you looking to repair?");
                int componentAmount = Integer.parseInt(scanner.nextLine());
                // Make List for components
                ArrayList<Component> componentList = new ArrayList<>();

                for (int i = 0; i < componentAmount; i++) {

                    String componentName = null;
                    LOGGER.info("Name of component that needs repair");
                    try {
                        componentName = scanner.nextLine();
                        if(componentName.equals("Cpu") || componentName.equals("Keyboard") || componentName.equals("Storage")
                        || componentName.equals("Ram") || componentName.equals("Motherboard")){} else {
                        throw new InvalidComponentException("Error: Invalid Component Name");
                        }
                    }catch (InvalidComponentException e){
                        LOGGER.info("Error: Invalid Component Name");
                        ;

                    }
                    LOGGER.info("Model of component that needs repair");
                    String componentModel = scanner.nextLine();
                    LOGGER.info("Issue of component that needs repair");
                    int componentIssue = Integer.parseInt(scanner.nextLine());

                    switch (componentName) {
                        case "Cpu":
                            LOGGER.info("Amount of cores");
                            int coresNumber = Integer.parseInt(scanner.nextLine());
                            Cpu cpuMade = new Cpu(componentName, componentModel, componentIssue, coresNumber);
                            componentList.add(i, cpuMade);


                            break;
                        case "Keyboard":
                            LOGGER.info("Select LED color");
                            String ledColor = scanner.nextLine();
                            Keyboard keyboardMade = new Keyboard(componentName, componentModel, componentIssue, ledColor);
                            componentList.add(i, keyboardMade);

                            break;
                        case "Motherboard":
                            LOGGER.info("Ram slots");
                            int ramSlots = Integer.parseInt(scanner.nextLine());
                            Motherboard motherboardMade = new Motherboard(componentName, componentModel, componentIssue, ramSlots);
                            componentList.add(i, motherboardMade);

                            break;
                        case "Ram":
                            LOGGER.info("Amount of ram");
                            int ramAmount = Integer.parseInt(scanner.nextLine());
                            Ram ramMade = new Ram(componentName, componentModel, componentIssue, ramAmount);
                            componentList.add(i, ramMade);

                            break;
                        case "Storage":
                            LOGGER.info("Amount of storage");
                            int storageSize = Integer.parseInt(scanner.nextLine());
                            Storage storageMade = new Storage(componentName, componentModel, componentIssue, storageSize);
                            componentList.add(i, storageMade);

                            break;
                        default:
                            throw new InvalidComponentException("Invalid component name given");
                    }

                }

                // Add a list for order number to be able to save ordernumber and access your order later
                LOGGER.info("Name on card");
                String nameOnCard = scanner.nextLine();
                LOGGER.info("Card number");
                String cardNumber = scanner.nextLine();
                LOGGER.info("Expiration date");
                String expirationDate = scanner.nextLine();
                Card card = new Card();
                card.makeCard(nameOnCard, cardNumber, expirationDate);
                ComputerRepairService.addCard(card);
                Order orderCreated = new Order();
                orderCreated.makeOrder(ComputerRepairService.getOrderAmount(), customerCreated, employeeAssigned, componentList);
                ComputerRepairService.addOrder(orderCreated);
                LOGGER.info("Order was created, your order number is: " + ComputerRepairService.getOrderAmount());
                ComputerRepairService.increaseOrderAmount();

                break;
            case "2":
                LOGGER.info("Insert your Order Number");
                int orderNumber = Integer.parseInt(scanner.nextLine());
                Order order = ComputerRepairService.getOrder(orderNumber);
                System.out.println(order);
                System.out.println(order.getComponentList());

                int totalCost = order.repairPartCost();
                LOGGER.info("Total Cost is: " + totalCost);

                break;
            case "3":
                LOGGER.info("Insert your Order Number");
                int orderNumber3 = Integer.parseInt(scanner.nextLine());
                ComputerRepairService computerRepairService = new ComputerRepairService();
                LOGGER.info(computerRepairService.retrieveCard(orderNumber3));
                break;
            case "9":
                printOptions();
                do {
                    option = scanner.next();
                    makeAChoice(option);
                } while (!option.equals("0"));

            default:
                String message2 = "Error: You chose invalid menu option";
                throw new InvalidMenuOptionException(message2);
        }
    }

    private static void printEmployeeOptions() {
        LOGGER.info("1 - Show list of employees");
        LOGGER.info("2 - Finish order");
        LOGGER.info("3 - Show list of orders");
        LOGGER.info("4 - Show customer payment information");
        LOGGER.info("9 - To main page");
    }

    private static void makeEmployeeChoice(String option) throws InvalidNameException, InvalidEmailException, InvalidComponentException, InvalidMenuOptionException {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case "1":
                ComputerRepairService.showEmployeeList();
                break;
            case "2":
                LOGGER.info("Insert Order Number");
                int orderNumber = Integer.parseInt(scanner.nextLine());
                ComputerRepairService.removeFromOrderList(orderNumber);
                ComputerRepairService.removeCard(orderNumber);
                ComputerRepairService.decreaseOrderAmount();
                break;
            case "3":
                ComputerRepairService.showOrderList();
                break;
            case "4":
                LOGGER.info("Insert Order Number");
                int orderNumber4 = Integer.parseInt(scanner.nextLine());
                ComputerRepairService.showCardList();
            case "9":
                printOptions();
                do {
                    option = scanner.next();
                    makeAChoice(option);
                } while (!option.equals("0"));
                break;
            default:
                String message = "Error: You chose an invalid menu option";
                throw new InvalidMenuOptionException(message);
        }
    }

    private static void printManagementOptions() {
        LOGGER.info("1 - Add employee to list");
        LOGGER.info("2 - Remove employee from list");
        LOGGER.info("9 - To main page");
    }

    private static void makeManagementChoice(String option) throws InvalidComponentException, InvalidNameException, InvalidEmailException, InvalidMenuOptionException {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case "1":
                LOGGER.info("Name of employee");
                String employeeName = scanner.nextLine();
                LOGGER.info("Id of employee");
                int employeeId = Integer.parseInt(scanner.nextLine());

                Employee employeeCreated = new Employee(employeeName, employeeId);
                ComputerRepairService.addEmployee(employeeCreated);

                break;
            case "2":
                LOGGER.info("Name of employee");
                String employeeName2 = scanner.nextLine();
                LOGGER.info("Id of employee");
                int employeeId2 = Integer.parseInt(scanner.nextLine());

                ComputerRepairService.removeFromEmployeeList(employeeId2);
                break;
            case "9":
                printOptions();
                do {
                    option = scanner.next();
                    makeAChoice(option);
                } while (!option.equals("0"));
                break;
        }
    }
        public static void continueOperation() {
            LOGGER.info("Click 1 to go main page");
            LOGGER.info("Click 0 to exit     ");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    printOptions();
                    break;
                case "0":
                    LOGGER.info("Have a nice day");
                    break;
                default:
                    LOGGER.info("Please chose an option");
                    continueOperation();
                    break;
            }
        }

    }



