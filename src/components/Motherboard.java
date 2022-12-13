package components;

public class Motherboard extends Component{
    int ramSlots;
    final int motherboardCost = 270;

    public Motherboard(String name, String model, int issue, int ramSlots) {
        super(name, model, issue);
        this.ramSlots = ramSlots;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public void setRamSlots(int ramSlots) {
        this.ramSlots = ramSlots;
    }

    public int getMotherboardCost() {
        return motherboardCost;
    }
    @Override
    public String toString() {
        return "Motherboard{" +
                "ramSlots=" + ramSlots +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", issue=" + issue +
                '}';
    }
}
