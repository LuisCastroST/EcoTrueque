package com.example.ecotrueque;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class PublicarObjetoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_publicar_objeto);

        EditText edtNombreObjeto =
                findViewById(R.id.editNombreObjeto);

        RadioGroup radioGroupCategoria =
                findViewById(R.id.radioGroupCategoria);

        Button btnPublicar =
                findViewById(R.id.btnPublicar);

        btnPublicar.setOnClickListener(v -> {

            String nombreObjeto =
                    edtNombreObjeto.getText().toString().trim();

            if (nombreObjeto.isEmpty()) {

                edtNombreObjeto.setError(
                        "Debes ingresar el nombre del objeto"
                );

                edtNombreObjeto.requestFocus();

                return;
            }

            int idSeleccionado =
                    radioGroupCategoria.getCheckedRadioButtonId();

            if (idSeleccionado == -1) {
                return;
            }

            RadioButton radioSeleccionado =
                    findViewById(idSeleccionado);

            String categoria =
                    radioSeleccionado.getText().toString();

            Intent intent = new Intent(
                    PublicarObjetoActivity.this,
                    DetalleObjetoActivity.class
            );

            intent.putExtra("NOMBRE_OBJETO", nombreObjeto);
            intent.putExtra("CATEGORIA", categoria);

            startActivity(intent);
        });
    }
}