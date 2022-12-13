package person;

import person.Person;

public class Employee extends Person {
    int taskId;
    //List of orders, irders he is workin on ADD

    public Employee(String fullname, int taskId) {
        super(fullname);
        setTaskId(taskId);
    }
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return '{' + "name=" + getFullname() +
                " and taskId=" + taskId +
                '}';
    }
}
