package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

public class AddressJsonIO {

        public String addressJsonFileName;

        public AddressJsonIO(String addressBookJsonFileName) {
            super();
            this.addressJsonFileName = addressBookJsonFileName;
        }

        //written contact details in a file
        public void writeContactDetailsInAFile(List<Contacts> list) {
            try {
                Gson gson = new Gson();
                String json = gson.toJson(list);
                FileWriter writer = new FileWriter(this.addressJsonFileName);
                writer.write(json);
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        //reads the addressBook
        public List<Contacts> readAddressBookFromAFile() {
            List<Contacts> list = new ArrayList<>();
            try {
                Gson gson = new Gson();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.addressJsonFileName));
                Contacts[] contactsArray = gson.fromJson(bufferedReader, Contacts[].class);
                list = new LinkedList<Contacts>(Arrays.asList(contactsArray));
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return list;
        }
}

