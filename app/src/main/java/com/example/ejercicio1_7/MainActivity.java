package com.example.ejercicio1_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void controlTemperatura(View view) {
        final TextView txtTemperatura = findViewById(R.id.textTemperatura);
        String [] trozos = txtTemperatura.getText().toString().split(":");
        int temperatura = Integer.parseInt(trozos[1].trim());

        switch (view.getId()){
            case R.id.buttonSubirTemperatura:
                txtTemperatura.setText("Temperatura actual :" + (temperatura+1));
                break;
            case R.id.buttonBajarTemperatura:
                txtTemperatura.setText("Temperatura actual :" + (temperatura-1));
                break;
            default:
        }

    }

    public void encenderLuces(View view) {
        final Switch switchLuces = findViewById(R.id.switchLuces);
        final ImageView imgLuces = findViewById(R.id.imageLuces);

        if (switchLuces.isChecked())
            imgLuces.setImageResource(R.drawable.bombilla_encendida);
        else
            imgLuces.setImageResource(R.drawable.bombilla_apagada);
    }

    public void controlPersianas(View view){
        final ImageView imgPersiana1 = findViewById(R.id.imagePersiana1);
        final ImageView imgPersiana2 = findViewById(R.id.imagePersiana2);
        final ImageView imgPersiana3 = findViewById(R.id.imagePersiana3);
        final ToggleButton btnPersiana = findViewById(R.id.toggleButton_Persianas);

        if (btnPersiana.isChecked()){
            imgPersiana1.setImageResource(R.drawable.persianas_subidas);
            imgPersiana2.setImageResource(R.drawable.persianas_subidas);
            imgPersiana3.setImageResource(R.drawable.persianas_subidas);
        }
        else
        {
            imgPersiana1.setImageResource(R.drawable.persiana_bajada);
            imgPersiana2.setImageResource(R.drawable.persiana_bajada);
            imgPersiana3.setImageResource(R.drawable.persiana_bajada);
        }
    }

    public void verEstadoPerro(View view) {
        final ImageView imgPerro = findViewById(R.id.imageEstadoPerro);
        int temperaturaActual = temperaturaActual();
        if (temperaturaActual>=40){
            imgPerro.setImageResource(getImageId(this,"imagen4"));
            imgPerro.setVisibility(View.VISIBLE);
        }
        else{
            int imgRandom = (int) ((Math.random() * 3) + 1);
            String img = "imagen" + imgRandom;
            imgPerro.setImageResource(getImageId(this,img));
            imgPerro.setVisibility(View.VISIBLE);
        }
    }

    public int temperaturaActual()
    {
        final TextView txtTemperatura = findViewById(R.id.textTemperatura);
        String [] trozos = txtTemperatura.getText().toString().split(":");
        int temperatura = Integer.parseInt(trozos[1].trim());
        return temperatura;
    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
}
