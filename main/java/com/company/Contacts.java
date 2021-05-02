package com.company;

public class Contacts {
    //constructors
    private String firstName;
    private String lastName,emailId,cityName;
    private String address,zipCode,stateName;
    private String phoneNumber;

    //Getters and setters for getting the details as input in addressBook
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Contacts(String firstName, String lastName, String emailId, String cityName, String address,
                    String zipCode, String stateName, String phoneNumber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.cityName = cityName;
        this.address = address;
        this.zipCode = zipCode;
        this.stateName = stateName;
        this.phoneNumber = phoneNumber;
    }
    public String toString() {
        return ("First Name: "+firstName+"\nLastName: "+lastName+"\nEmailId: "+emailId+"\nCity: "+cityName+"\nAddress: "+address+"\nZipCode: "+zipCode+"\nState: "+stateName+"\nPhoneNumber: "+phoneNumber);
    }

    //checking firstname and lastname
    public boolean equals(Object obj) {
        Contacts conObj = (Contacts)obj;
        if (conObj.getFirstName().equals(this.firstName) && conObj.getLastName().equals(this.lastName) )
            return true;
        else
            return false;
    }

}