package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {

    //Called list , hashmap
    public  static  List<Contacts> contactList = new ArrayList<>();
    public static Map<String, Contacts > addressMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    public AddressCsvIO addressFileObj;
    public List<Contacts> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contacts> list) {
        this.contactList = list;
    }

    //added contact in addressBook
    public void addContact(String addBookName)
    {
        addressFileObj = new AddressCsvIO(addBookName + ".txt");
        System.out.println("Enter the number of persons whose contact details are to be added: ");
        int noOfPersons=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<noOfPersons;i++)
        {
            System.out.println("Enter Contact Details of Person "+(i+1)+" :");
            System.out.println("Enter First Name: ");
            String fn=sc.nextLine();
            System.out.println("Enter Last Name: ");
            String ln=sc.nextLine();
            System.out.println("Enter Address: ");
            String add=sc.nextLine();
            System.out.println("Enter City: ");
            String c=sc.nextLine();
            System.out.println("Enter State: ");
            String s=sc.nextLine();
            System.out.println("Enter Zip Code: ");
            String zc=sc.nextLine();
            System.out.println("Enter Phone Number: ");
            String pn=sc.nextLine();
            System.out.println("Enter EmailId: ");
            String ei=sc.nextLine();
            Contacts contactObj = new Contacts(fn,ln,ei,c,add,zc,s,pn);
            contactList.add(contactObj);
            addressFileObj.writeContactDetailsInAFile(contactList);
            addressMap.put(contactObj.getFirstName(), contactObj);
        }
    }

    //Edited the details in addressBook
    public void editContact()
    {
        int x;
        boolean flag = true;
        contactList = addressFileObj.readAddressBookFromAFile();
        System.out.println("Do you want to edit contact details (Y/N-y/n): ");
        char ch=sc.next().charAt(0);
        sc.nextLine();
        while(flag)
        {
            if(ch=='N' || ch=='n')
            {
                System.out.println("User does not want to edit contact details.");
                break;
            }

            System.out.println("Enter the first name whose contact details is to be edited: ");
            String editN = sc.nextLine();
            x=0;
            for(int i = 0;i<contactList.size();i++)
            {
                if((ch=='Y' || ch=='y') && contactList.get(i).getFirstName().equals(editN))
                {
                    System.out.println("Enter New Details: ");
                    System.out.println("Enter First Name: ");
                    String fn=sc.nextLine();
                    System.out.println("Enter Last Name: ");
                    String ln=sc.nextLine();
                    System.out.println("Enter Address: ");
                    String add=sc.nextLine();
                    System.out.println("Enter City: ");
                    String c=sc.nextLine();
                    System.out.println("Enter State: ");
                    String s=sc.nextLine();
                    System.out.println("Enter Zip Code: ");
                    String zc=sc.nextLine();
                    System.out.println("Enter Phone Number: ");
                    String pn=sc.nextLine();
                    System.out.println("Enter EmailId: ");
                    String ei=sc.nextLine();
                    Contacts contactObj = new Contacts(fn,ln,ei,c,add,zc,s,pn);
                    contactList.set(i, contactObj);
                    System.out.println("Contact details of "+editN+" edited successfully! Updated Details are: ");
                    addressFileObj.writeContactDetailsInAFile(contactList);
                    x=1;
                    flag= false;
                    break;
                }
            }
            if(x==0 && (ch=='Y' || ch=='y'))
                System.out.println("User contact details not available.Please enter correct first name.");
        }
    }
    //Deleting the details
    public void removeContact() {
        boolean flag = true;
        int x;
        contactList = addressFileObj.readAddressBookFromAFile();
        System.out.println("Do you want to remove contact details (Y/N-y/n): ");
        char ch=sc.next().charAt(0);
        sc.nextLine();
        while(flag)
        {
            if(ch=='N' || ch=='n')
            {
                System.out.println("User does not want to remove contact details.");
                break;
            }
            System.out.println("Enter the first name whose contact details is to be removed: ");
            String removeN = sc.nextLine();
            x=0;
            for(Contacts l : contactList)
            {
                if((ch=='Y' || ch=='y') && l.getFirstName().equals(removeN))
                {
                    contactList.remove(x);
                    System.out.println("Contact Details removed successfully!! Updated Details are: ");
                    addressFileObj.writeContactDetailsInAFile(contactList);
                    x=1;
                    flag = false;
                    break;
                }
            }
            if(x==0 && (ch=='Y' || ch=='y'))
                System.out.println("User contact details not available.Please enter correct first name.");
        }
    }

    //Checking if any duplicate entries occurs
    public void checkDuplicateEntryOfName()
    {
        long counter= 0;
        System.out.println("Enter first and last name to check for repeatition :");
        String firstName = sc.nextLine();
        String lastName = sc.nextLine();
        contactList = addressFileObj.readAddressBookFromAFile();
        counter = contactList.stream().filter( (conObj) ->  (conObj.getFirstName() +" " + conObj.getLastName()).equals(firstName + " " + lastName)).count();
        if(counter==0)
            System.out.println("Duplicate entry does not exist.");
        else
            System.out.println("Already a person with similar details exists.");
    }
    /**
     * UC11
     */

    //sorting contacts by first name
    public void sortContactsByName() {
        contactList = addressFileObj.readAddressBookFromAFile();
        contactList=contactList.stream().sorted((c1,c2)->c1.getFirstName().compareTo(c2.getFirstName())).collect(Collectors.toList());
    }

    /**
     * UC12
     */

    //Sorting contacts by city or state or zipcode in addressBook
    public void sortContactsByCityOrStateOrZip(){
        System.out.println("Press 1 to sort by city ,2 to sort by state , to sort by zip code");
        int choice = sc.nextInt();
        contactList = addressFileObj.readAddressBookFromAFile();
        switch(choice) {
            case 1:
                contactList = contactList.stream().sorted((c1,c2)->c1.getCityName().compareTo(c2.getCityName())).collect(Collectors.toList());
            case 2:
                contactList = contactList.stream().sorted((c1,c2)->c1.getStateName().compareTo(c2.getStateName())).collect(Collectors.toList());
            case 3:
                contactList = contactList.stream().sorted((c1,c2)->(c1.getZipCode()).compareTo(c2.getZipCode())).collect(Collectors.toList());
        }
    }
    public static void main(String[] args) {
        AddressBookMain mainObj = new AddressBookMain();
        AddressBook addressObj = new AddressBook();
        while(true)
        {
            System.out.println("Enter name of the Address Book");
            String addressBookName = sc.nextLine();
            if(addressObj.addressBook.containsKey(addressBookName))
                System.out.println("Address Book with same name already exists");
            else {
                System.out.println("Enter Details for " + addressBookName);
                mainObj.addContact(addressBookName);
                addressObj.addressBook.put(addressBookName,mainObj);
            }
            System.out.println("Do you want to add more Address Books (y/n)");
            if(sc.next().equals("y"))
                continue;
            else
                break;
        }
        for(int j=0;j<contactList.size();j++)
        {
            System.out.println("Contact Details of Person "+(j+1)+" :");
            System.out.println(contactList.get(j));
        }
        mainObj.editContact();
        mainObj.removeContact();
        addressObj.showAddressBooks();
        mainObj.checkDuplicateEntryOfName();
        addressObj.viewPersonByCityOrState();
        addressObj.dictionaryOfState_PersonsAndCity_Persons();
        AddressBook.showCountOfPersonsByCityAndState();
        mainObj.sortContactsByName();
        mainObj.sortContactsByCityOrStateOrZip();

    }
}