package com.example.john.myapplication;

import java.util.ArrayList;

/**
 * Created by John on 4/14/16.
 */
public class listStorage {

   static ArrayList<String> toDoArray = new ArrayList<>();


//    static String tester = "tester";

    public static String setItemToArrayList(String thing){
toDoArray.add(thing);
        return toDoArray.get(0);
    }
}
