package com.example.john.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;





public class MainActivity extends AppCompatActivity {

    LinkedList<String> strList;

    ArrayAdapter<String> mAdapter;

//    ArrayList<String> toDoArray = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strList = new LinkedList<>();

        mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,strList);

        ListView listView = (ListView)findViewById(R.id.list_view);

        listView.setAdapter(mAdapter);

        listStorage.getTester();

        Toast.makeText(MainActivity.this,
                listStorage.toDoArray.get(0)
                , Toast.LENGTH_SHORT).show();


        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText et1 = (EditText) findViewById(R.id.editText);
                String sTextFromET = et1.getText().toString();

                Log.e("cool", "variable is " + sTextFromET);

                strList.add(sTextFromET);
                et1.setText("");
                mAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this,
                        "Item Added", Toast.LENGTH_SHORT).show();

               //add to array here to placehold




                //Below in the intents send both the string name and the entire array over

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                strList.remove(position);
                mAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this,
                        "Item Deleted", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


//maybe split the array?


//convert placeholder split array
//                String strArray[] = toDoArray.get(position).split("");
                //convert to arraylist

//                ArrayList<String> arraylist = new ArrayList<String>(Arrays.asList(strArray));

                String str1 = strList.get(position);

                //converting 2nd arraylist to an array to prepare to intent?

//                String list2[] = new String[toDoArray.size()];

                //storing new array into variable

//                list2 = toDoArray.toArray(list2);

                //console logging array to string conversion

//                Log.e("cool", Arrays.toString(strArray));

//              long id will match the array of the other to do array...or position?

                Intent intent = new Intent(MainActivity.this, main2Activity.class);
                intent.putExtra("Title", str1);
                //send off arraylist
                intent.putStringArrayListExtra("list", listStorage.toDoArray);
                startActivity(intent);

            }


        });



    }
}

