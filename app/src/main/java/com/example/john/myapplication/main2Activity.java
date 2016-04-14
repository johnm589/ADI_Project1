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

public class main2Activity extends AppCompatActivity {

    private ListView lv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        final int position = intent.getIntExtra("position", -1);
//        final ArrayList<String> arrayOne = intent.getStringArrayListExtra("list");

//        TextView tv = (TextView) findViewById(R.id.textView);
//        TextView tv2 = (TextView) findViewById(R.id.textView2);
        lv2 = (ListView) findViewById(R.id.listview2);


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listStorage.arrayOfLists.get(position));

        lv2.setAdapter(arrayAdapter);
//        tv.setText(stringOne);
//        tv2.setText(listStorage.toDoArray.toString());

        Toast.makeText(this,
                "Test", Toast.LENGTH_SHORT).show();



        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et2 = (EditText) findViewById(R.id.editText2);
                String sTextFromET2 = et2.getText().toString();

                Log.e("cool", "variable is " + sTextFromET2);

//                listStorage.setTester(sTextFromET2);
                listStorage.arrayOfLists.get(position).add(sTextFromET2);
//                listStorage.arrayOfLists;

                et2.setText("");
                arrayAdapter.notifyDataSetChanged();

                Toast.makeText(main2Activity.this,
                        "Item Added", Toast.LENGTH_SHORT).show();

                //add to array here to placehold


                //Below in the intents send both the string name and the entire array over

            }
        });
        lv2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                listStorage.arrayOfLists.get(position).remove(position);
                arrayAdapter.notifyDataSetChanged();

                Toast.makeText(main2Activity.this,
                        "Item Deleted", Toast.LENGTH_SHORT).show();
                return true;
            }
        });



    }
//    @Overridedf
//    public void onBackPressed() {
//    }
}
