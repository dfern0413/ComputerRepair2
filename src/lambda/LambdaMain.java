package lambda;


import exception.InvalidEmailException;
import exception.InvalidNameException;
import linkedList.LinkedListMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import person.Customer;

import java.util.ArrayList;
import java.util.List;

public class LambdaMain {
    private final static Logger LOGGER = LogManager.getLogger(LambdaMain.class);
    public static void main(String[] args) throws InvalidNameException, InvalidEmailException {

        List<Customer> customerList = new ArrayList<>();

        Customer customer1 = new Customer("Jeff johns", "johny@gmail.com");
        customerList.add(customer1);
        Customer customer2 = new Customer("Mark James", "markson@gmail.com");
        customerList.add(customer2);

        IPrintable print = () -> LOGGER.info("Lambda being used");

    }
}
