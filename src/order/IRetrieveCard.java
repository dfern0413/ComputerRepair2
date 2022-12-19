package order;

import payment.Card;
import person.Employee;

import java.util.List;

public interface IRetrieveCard {
    Card retrieveCard(int orderNumber);
}
