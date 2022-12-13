package components;

public class Ram extends Component{
    int ramAmount;
    int ramCost;

    public Ram(String name, String model, int issue, int ramAmount) {
        super(name, model, issue);
        this.ramAmount = ramAmount;
    }

    public int getRamAmount() {
        return ramAmount;
    }

    public void setRamAmount(int ramAmount) {
        this.ramAmount = ramAmount;
    }

    public int getRamCost() {
        return ramCost;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "ramAmount=" + ramAmount +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", issue=" + issue +
                '}';
    }
}
