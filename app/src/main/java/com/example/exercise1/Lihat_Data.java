package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Lihat_Data extends AppCompatActivity {

    TextView tvnama,tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat__data);

        this.tvnama = (TextView) findViewById(R.id.tvNamaKontak);
        this.tvnomor = (TextView) findViewById(R.id.tvNomorTelepon);

        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");
        switch (nama)
        {
            case "Inayah":
                this.tvnama.setText("Inayah M");
                this.tvnomor.setText("0812");
            case "Ilham":
                this.tvnama.setText("Ilham R");
                this.tvnomor.setText("0813");
            case "Eris":
                this.tvnama.setText("Eris J");
                this.tvnomor.setText("0814");
            case "Fikri":
                this.tvnama.setText("M Fikri");
                this.tvnomor.setText("0815");
            case "Maul":
                this.tvnama.setText("Maul M");
                this.tvnomor.setText("0816");
            case "Intan":
                this.tvnama.setText("Intan M");
                this.tvnomor.setText("0817");
            case "Vina":
                this.tvnama.setText("Vina R");
                this.tvnomor.setText("0818");
            case "Gita":
                this.tvnama.setText("Gita s");
                this.tvnomor.setText("0819");
            case "Lutfi":
                this.tvnama.setText("Lutfi M");
                this.tvnomor.setText("0820");
            case "Vian":
                this.tvnama.setText("Vian M");
                this.tvnomor.setText("0821");
        }
    }
}