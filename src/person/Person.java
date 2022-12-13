package person;

public abstract class Person {
    private String fullname;

    public Person(String fullname) {
        this.fullname = fullname;

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullname='" + fullname + '\'' +
                '}';
    }
}
