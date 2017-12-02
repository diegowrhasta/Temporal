package com.example.diego.temporal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diego.temporal.Objetos.FireBaseReferences;
import com.example.diego.temporal.Objetos.usuario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Crear_Perfil extends AppCompatActivity {
    private Button btn1;
    public EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear__perfil);
        btn1=(Button)findViewById(R.id.bt1);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(FireBaseReferences.CUENTAS_REFERENCE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernam=et1.getText().toString();
                Log.i("Username",usernam+"");
                String pass=et2.getText().toString();
                Log.i("Username",pass+"");
                usuario user=new usuario(usernam,pass,true);
                myRef.push().setValue(user);
                Toast.makeText(Crear_Perfil.this, "Se creó el usuario con éxito", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Crear_Perfil.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
    public void guardarperfil(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
