package person;


import exception.InvalidEmailException;
import exception.InvalidNameException;

import java.util.ArrayList;
import java.util.Objects;

public class Customer extends Person{
    String emailAddress;

    public Customer(String fullname, String emailAddress) throws InvalidNameException, InvalidEmailException {
        super(fullname);
        if(fullname == null){
            throw new InvalidNameException("Invalid Customer name");
        }
        this.emailAddress = emailAddress;
        if(this.emailAddress == null ){
            throw new InvalidEmailException("Invalid Email");
        }
    }
    @Override
    public String toString() {
        return '{' + "name=" + getFullname() +
                " and emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

