package org.example;

import java.time.ZonedDateTime;

public class Entry {

    public String name;

    public String firstName;
    public String lastName;
    public String orderNum;
    public ZonedDateTime currentDate;



    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    // First name setter
    public void setFirstName(String fName){
        firstName = fName;
    }

    // First name getter
    public String getFirstName() {
        return firstName;
    }

    // Last name setter
    public void setLastName(String lName) {
        lastName = lName;
    }

    // Last name getter
    public String getLastName() {
        return lastName;
    }

    // Order num setter
    public void setOrderNum(String o){
        orderNum = o;
    }

    // Order num getter
    public String getOrderNum(){
        return orderNum;
    }

    // Date setter
    public void setDateCreated(ZonedDateTime date) {
        currentDate = date;
    }

    // Date getter
    public ZonedDateTime getDateCreated() {
        return currentDate;
    }

}
