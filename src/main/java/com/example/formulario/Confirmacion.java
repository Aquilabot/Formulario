package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Confirmacion extends AppCompatActivity {

    private Contacto datos = new Contacto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        this.setTitle(R.string.tl_confirmacion);
        //para evitar null excpetion si no se llenan los datos
        if(getIntent().getExtras().getSerializable("datos")!=null){
            this.datos = (Contacto) getIntent().getExtras().getSerializable("datos");
        }
        else{
            datos.setNombre("");
            datos.setFecha("");
            datos.setTelefono("");
            datos.setCorreo("");
            datos.setDescripcion("");
        }

        TextView name = (TextView) findViewById(R.id.nombre);
        TextView date = (TextView) findViewById(R.id.fecha);
        TextView phone= (TextView) findViewById(R.id.telefono);
        TextView email = (TextView) findViewById(R.id.email);
        TextView description = (TextView) findViewById(R.id.descripcion);

        String nombre= "Nombre : "+datos.getNombre();
        String fecha = "Fecha : "+datos.getFecha();
        String telefono = "Telefono : "+datos.getTelefono();
        String correo = "Correo : "+datos.getCorreo();
        String descripcion = "Descripcion : "+datos.getDescripcion();

        name.setText(nombre);
        date.setText(fecha);
        phone.setText(telefono);
        email.setText(correo);
        description.setText(descripcion);
    }

    public void toFormulario(View view){
        Intent i = new Intent(this,Formulario.class);
        i.putExtra("datos",datos);
        startActivity(i);
    }

    public void crearContacto(View view){
        Intent i = new Intent(this,Formulario.class);
        startActivity(i);
        finish();
        Toast.makeText(this,R.string.Toast_CrearContacto,Toast.LENGTH_LONG).show();
    }
}