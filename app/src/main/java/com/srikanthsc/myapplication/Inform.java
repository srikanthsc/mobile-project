package com.srikanthsc.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inform extends AppCompatActivity {


    EditText Lastname, Fistname, date;
    Button insert, update, delete, view;
    MyData DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform);
        Lastname = findViewById(R.id.Lastname);
        Fistname = findViewById(R.id.Firstname);
        date = findViewById(R.id.dob);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new MyData(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String LastnameTXT = Lastname.getText().toString();
                String FistnameTXT = Fistname.getText().toString();
                String pnTXT = date.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(LastnameTXT, FistnameTXT, pnTXT);
                if(checkinsertdata==true)
                    Toast.makeText(Inform.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Inform.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String LastnameTXT = Lastname.getText().toString();
                String FirstnameTXT = Fistname.getText().toString();
                String resultTXT = date.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(LastnameTXT, FirstnameTXT, resultTXT);
                if(checkupdatedata==true)
                    Toast.makeText(Inform.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Inform.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String LastnameTXT = Lastname.getText().toString();
                Boolean checkudeletedata = DB.deletedata(LastnameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(Inform.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Inform.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(Inform.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Lastname :"+ ((Cursor) res).getString(0)+"\n");
                    buffer.append("Firstname :"+res.getString(1)+"\n");
                    buffer.append("xx/xx/xxxx :"+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(  Inform.this);
                builder.setCancelable(true);
                builder.setTitle("Data");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });

    }
}