package enums;

public enum CardType {
    MASTERCARD("Credit Card"),
    VISA("CASH");

    final String cardType;

    CardType(String cardType){
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }
}
