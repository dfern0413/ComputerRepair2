package order;

import payment.Card;
import person.Employee;

import java.util.List;

public interface IRetrieveFromList {
    Card retrieveCard(int orderNumber);
    List<Employee> retrieveEmployeeList();
}
