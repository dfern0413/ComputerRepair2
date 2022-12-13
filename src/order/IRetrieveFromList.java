package order;

import payment.Card;

public interface IRetrieveFromList {
    Card retrieveCard(int orderNumber);
}
