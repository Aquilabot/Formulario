package com.example.formulario;

import com.example.formulario.Formulario.*;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class Formulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        this.setTitle(R.string.tl_formulario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            Contacto datos = (Contacto) getIntent().getExtras().getSerializable("datos");

            EditText nombre= (EditText) findViewById(R.id.editTextTextPersonName);
            EditText fecha= (EditText) findViewById(R.id.editTextDate);
            EditText telefono= (EditText) findViewById(R.id.editTextPhone);
            EditText correo= (EditText) findViewById(R.id.editTextTextEmailAddress);
            EditText descripcion= (EditText) findViewById(R.id.editTextTextMultiLine);

            nombre.setText(datos.getNombre());
            fecha.setText(datos.getFecha());
            telefono.setText(datos.getTelefono());
            correo.setText(datos.getCorreo());
            descripcion.setText(datos.getDescripcion());
        }
    }

    public void toConfirmacion(View view){
        Intent i = new Intent(Formulario.this,Confirmacion.class);

        EditText nombre = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText fecha = (EditText) findViewById(R.id.editTextDate);
        EditText telefono = (EditText) findViewById(R.id.editTextPhone);
        EditText correo = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText descripcion = (EditText) findViewById(R.id.editTextTextMultiLine);

        Contacto contacto = new Contacto(nombre.getText().toString(),fecha.getText().toString()
                                        ,telefono.getText().toString(),
                                        correo.getText().toString()
                                        ,descripcion.getText().toString());

        i.putExtra("datos",contacto);

        startActivity(i);
    }

    public void elegirFecha(View v){

        switch (v.getId()){
            case R.id.editTextDate:
                obtenerFecha();
                break;
        }
    }


    public void obtenerFecha(){

        final Calendar c = Calendar.getInstance();
        int anio = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? "0" + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? "0"+ String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                String fechaSeleccionada =diaFormateado + "/" + mesFormateado + "/" + year;
                EditText fecha = (EditText) findViewById(R.id.editTextDate);
                fecha.setText(fechaSeleccionada);

            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
            /**
             *También puede cargar los valores que usted desee
             */
        },anio, mes, dia);
        //Muestro el widget
        recogerFecha.show();

    }

}