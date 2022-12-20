package enums;

public enum PaymentType {
    CREDITCARD("Credit Card"),
    CASH("CASH"),
    DEBITCARD("Debit Card");

    final String payment;

    PaymentType(String payment){
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }
}
