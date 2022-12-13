package components;

public class Keyboard extends Component{
    String ledColor;
    final int keyboardCost = 45;

    public Keyboard(String name, String model, int issue, String ledColor) {
        super(name, model, issue);
        this.ledColor = ledColor;
    }

    public String getLedColor() {
        return ledColor;
    }

    public void setLedColor(String ledColor) {
        this.ledColor = ledColor;
    }

    public int getKeyboardCost() {
        return keyboardCost;
    }


    @Override
    public String toString() {
        return "Keyboard{" +
                "ledColor='" + ledColor + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", issue=" + issue +
                '}';
    }

}
