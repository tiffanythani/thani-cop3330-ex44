/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tiffany Thani
 */

import java.util.*;
import java.lang.*;
import java.io.*;
import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Exercise44 {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        try {
            //reads json file and stores in obj
            Object obj = parser.parse(new FileReader("D:/products.json"));
            //json object is created to read internal values

            JSONObject jsonObject = (JSONObject)obj;
            //reads product array from file
            JSONArray subjects = (JSONArray)jsonObject.get("products");
            //Create buffered reader object to take user input
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String input;
            //the flag shows if the string is present or not
            int flag = 0;
            System.out.print("What is the product name? ");
            input = bufferedReader.readLine();
            //iterator for products array
            Iterator iter = subjects.iterator();
            //loop through the iterator
            while (iter.hasNext()) {
                //Create another json
                JSONObject json = (JSONObject) iter.next();
                //name value is retrieved
                String name = (String)json.get("name");
                //and then compared with input
                if(input.toLowerCase().equals(name.toLowerCase())){
                    System.out.println("Name: "+name);
                    System.out.println("Price: "+json.get("price"));
                    System.out.println("Quantity: "+json.get("quantity"));
                    flag = 1;
                }
            }
            //the value is not found if flag value is 0
            if(flag == 0){
                System.out.println("Sorry, that product was not found in our inventory");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}