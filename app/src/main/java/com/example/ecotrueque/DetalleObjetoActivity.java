package com.example.ecotrueque;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleObjetoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle_objeto);

        TextView txtNombreDetalle =
                findViewById(R.id.txtNombreDetalle);

        TextView txtCategoriaDetalle =
                findViewById(R.id.txtCategoriaDetalle);

        Button btnVolverMenu =
                findViewById(R.id.btnVolver);

        Intent intentRecibido = getIntent();

        String nombreObjeto =
                intentRecibido.getStringExtra("NOMBRE_OBJETO");

        String categoria =
                intentRecibido.getStringExtra("CATEGORIA");

        txtNombreDetalle.setText(
                "Objeto: " + nombreObjeto
        );

        txtCategoriaDetalle.setText(
                "Categoría: " + categoria
        );

        btnVolverMenu.setOnClickListener(v -> {

            Intent intent = new Intent(
                    DetalleObjetoActivity.this,
                    MenuPrincipalActivity.class
            );

            intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
            );

            startActivity(intent);
        });
    }
}