package components;

public abstract class Component {
    String name;
    String model;
    int issue;

    public Component(String name, String model, int issue) {
        this.name = name;
        this.model = model;
        this.issue = issue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", issue=" + issue +
                '}';
    }

}
