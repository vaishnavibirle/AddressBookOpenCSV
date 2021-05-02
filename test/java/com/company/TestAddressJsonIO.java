package com.company;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//Using JSON
public class TestAddressJsonIO {

    //Checking given contacts should match to json file contact entries
    @Test
    public void given3ContactsWhenWrittenToJSonFileShouldMatchContactEntries() {
        Contacts jeff=new Contacts("Jeff","Bezoss","jeff@gmail.com","San Francisco","Address","120012","California","+23-1234567890");
        Contacts mark=new Contacts("Mark","Zukerberg","mark@gmail.com","New York City","Address","123456","New York","+12-9874563210");
        Contacts satya=new Contacts("Satya", "Nadela","satya@gmail.com","Los Angeles","Address","120546","California","+11-5463217890");
        List<Contacts> contacts=Arrays.asList(new Contacts[] {jeff, mark, satya});
        AddressJsonIO addressBookJsonIOService=new AddressJsonIO("addressJSonTest.csv");
        addressBookJsonIOService.writeContactDetailsInAFile(contacts);
        List<Contacts> readContacts=addressBookJsonIOService.readAddressBookFromAFile();
        assertEquals(jeff.toString(),readContacts.get(0).toString());
        assertEquals(mark.toString(),readContacts.get(1).toString());
        assertEquals(satya.toString(),readContacts.get(2).toString());
    }
}
