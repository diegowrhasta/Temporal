package com.example.diego.temporal;

/**
 * Created by Diego on 13/05/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.diego.temporal.Objetos.FireBaseReferences;
import com.example.diego.temporal.Objetos.usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> v=new ArrayList<String>();
    EditText et1;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText)findViewById(R.id.et1);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(FireBaseReferences.CUENTAS_REFERENCE);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Log.i("Objeto", postSnapshot.child("username").getValue()+"");
                   v.add(postSnapshot.child("username").getValue(String.class));
                }
                sp=(Spinner)findViewById(R.id.mySpinner);
                ArrayAdapter<String> areasAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, v);
                areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp.setAdapter(areasAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ERROR",databaseError.getMessage());
            }
        });
    }
    public void sendMessage(View view)
    {
        final String usuario=sp.getSelectedItem().toString();
        final String contra=et1.getText().toString();
        Log.i("Lo que hay",usuario+";"+contra);
            Intent intent = new Intent(MainActivity.this, MenuApp.class);
            startActivity(intent);
    }
    public void crearperfil(View view)
    {
        Intent intent = new Intent(MainActivity.this, Crear_Perfil.class);
        startActivity(intent);
    }
}
