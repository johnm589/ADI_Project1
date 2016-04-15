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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listStorage.toDoArray);

        ListView listView = (ListView)findViewById(R.id.list_view);

        listView.setAdapter(mAdapter);


        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText et1 = (EditText) findViewById(R.id.editText);
                String sTextFromET = et1.getText().toString();

                Log.e("cool", "variable is " + sTextFromET);

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

                Intent intent = new Intent(MainActivity.this, main2Activity.class);
                intent.putExtra("position", position);

                startActivity(intent);
            }
        });
    }
}
