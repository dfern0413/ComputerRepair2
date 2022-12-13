package components;

public class Cpu extends Component{
    int cores;
    final int cpuCost = 250;

    public Cpu(String name, String model, int issue, int cores) {
        super(name, model, issue);
        this.cores = cores;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getCpuCost() {
        return cpuCost;
    }


    @Override
    public String toString() {
        return "Cpu{" +
                "cores=" + cores +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", issue=" + issue +
                '}';
    }
}
