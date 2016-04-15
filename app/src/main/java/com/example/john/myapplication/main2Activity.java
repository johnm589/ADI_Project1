package com.example.john.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class main2Activity extends AppCompatActivity {

    private ListView lv2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        final int position1 = intent.getIntExtra("position", -1);


        //Assigns views to variables
        lv2 = (ListView) findViewById(R.id.listview2);
        tv = (TextView) findViewById(R.id.title);


        //Changes Title
        tv.setText(listStorage.toDoArray.get(position1));


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listStorage.arrayOfLists.get(position1));

        lv2.setAdapter(arrayAdapter);

        Toast.makeText(this,
                "Test", Toast.LENGTH_SHORT).show();



        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et2 = (EditText) findViewById(R.id.editText2);
                String sTextFromET2 = et2.getText().toString();

                listStorage.arrayOfLists.get(position1).add(sTextFromET2);

                et2.setText("");
                arrayAdapter.notifyDataSetChanged();

                Toast.makeText(main2Activity.this,
                        "Item Added", Toast.LENGTH_SHORT).show();

            }
        });
        lv2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                listStorage.arrayOfLists.get(position1).remove(position);
                arrayAdapter.notifyDataSetChanged();

                Toast.makeText(main2Activity.this,
                        "Item Deleted", Toast.LENGTH_SHORT).show();
                return true;
            }
        });



    }
}
