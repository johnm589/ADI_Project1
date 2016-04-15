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

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ShakeListener mShaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listStorage.toDoArray);

        final ListView listView = (ListView)findViewById(R.id.list_view);

        listView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);

        //set Shake event listener
        mShaker = new ShakeListener(this);
        mShaker.setOnShakeListener(new ShakeListener.OnShakeListener() {
            public void onShake() {

                //for loop to iterate through array and delete
                if(listStorage.toDoArray.size() > 0 ){
                    for(int i = 0;i < listStorage.toDoArray.size(); i++ ) {
                        listStorage.toDoArray.remove(i);
                        }
                    }
                //for loop to iterate through array of array and delete
                if(listStorage.arrayOfLists.size() > 0){
                    for( int i = 0; i < listStorage.arrayOfLists.size(); i++){
                        listStorage.arrayOfLists.remove(i);
                    }
                }
                mAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,
                        "Shake?? Shaaaaaaaaaaake!!!!!", Toast.LENGTH_SHORT).show();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set up variables for view
                EditText et1 = (EditText) findViewById(R.id.editText);
                //grab text from edittext
                String sTextFromET = et1.getText().toString();

                Log.e("cool", "variable is " + sTextFromET);

                //add new arraylist
                ArrayList<String> listItems = new ArrayList<>();

                listStorage.toDoArray.add(sTextFromET);

                listStorage.arrayOfLists.add(listItems);

                et1.setText("");

                mAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this,
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //remove array
                listStorage.toDoArray.remove(position);
                listStorage.arrayOfLists.remove(position);
                mAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this,
                        "Item Deleted", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //intent start and pass over position information to next intent

                Intent intent = new Intent(MainActivity.this, main2Activity.class);
                intent.putExtra("position", position);

                startActivity(intent);
            }
        });
    }
}
