package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class  Pendaftaran extends AppCompatActivity {
    Button butDaftar, butBatal;
    TextView jeniskelamin;
    TextView agama;
    TextInputLayout rNamaError, rAlamatError, DaftEmailError, DaftPassError, DrepassError;
    EditText rNama, rAlamat, rEmail, rPass, rrepass;
    Boolean NamaValid, AlamatValid, EmailValid, PasswordValid, RePasswordValid;
    RadioButton idKepercayaan, Laki, Perempuan, Katolik, Islam, Konghucu, Budha, Hindu, Kristen;
    RadioGroup rgJenisKelamin, rgAgama1, rg2, rg3;
    String jk = "";
    String ja = "";
    private boolean isChecking = true;
    private int cekAgama;
    private int cekKelamin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);
        MenghubungkanKomponen();
        this.rgAgama1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && Pendaftaran.this.isChecking) {
                    Pendaftaran.this.isChecking = false;
                    Pendaftaran.this.rg2.clearCheck();
                    Pendaftaran.this.rg3.clearCheck();
                    Pendaftaran.this.cekAgama = i;
                }
                Pendaftaran.this.isChecking = true;
            }
        });
        this.rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && Pendaftaran.this.isChecking) {
                    Pendaftaran.this.isChecking = false;
                    Pendaftaran.this.rgAgama1.clearCheck();
                    Pendaftaran.this.rg3.clearCheck();
                    Pendaftaran.this.cekAgama = i;
                }
                Pendaftaran.this.isChecking = true;
            }
        });
        this.rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && Pendaftaran.this.isChecking) {
                    Pendaftaran.this.isChecking = false;
                    Pendaftaran.this.rgAgama1.clearCheck();
                    Pendaftaran.this.rg2.clearCheck();
                    Pendaftaran.this.cekAgama = i;
                }
                Pendaftaran.this.isChecking = true;
            }
        });
        this.rgJenisKelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1 && Pendaftaran.this.isChecking) {
                    Pendaftaran.this.isChecking = false;
                    Pendaftaran.this.cekKelamin = i;
                }
                Pendaftaran.this.isChecking = true;
            }
        });
        this.butDaftar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Pendaftaran.this.JenisAgama(view);
                Pendaftaran.this.JenisKelamin(view);
                Pendaftaran.this.validasi(view);
            }
        });
        this.butBatal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Pendaftaran.this.startActivity(new Intent(Pendaftaran.this.getApplicationContext(), MainActivity.class));
            }
        });
    }

    public void MenghubungkanKomponen() {
        this.rNama = (EditText) findViewById(R.id.DNama);
        this.rAlamat = (EditText) findViewById(R.id.DAlamat);
        this.rEmail = (EditText) findViewById(R.id.DEmail);
        this.rPass = (EditText) findViewById(R.id.DPw);
        this.rrepass = (EditText) findViewById(R.id.Drepass);
        this.rgJenisKelamin = (RadioGroup) findViewById(R.id.rgJenisKelamin);
        this.rgAgama1 = (RadioGroup) findViewById(R.id.rgAgama1);
        this.rg2 = (RadioGroup) findViewById(R.id.rg2);
        this.rg3 = (RadioGroup) findViewById(R.id.rg3);
        this.Laki = (RadioButton) findViewById(R.id.Laki);
        this.Perempuan = (RadioButton) findViewById(R.id.Perempuan);
        this.Islam = (RadioButton) findViewById(R.id.Islam);
        this.Katolik = (RadioButton) findViewById(R.id.Katolik);
        this.Kristen = (RadioButton) findViewById(R.id.Kristen);
        this.Konghucu = (RadioButton) findViewById(R.id.Konghucu);
        this.Hindu = (RadioButton) findViewById(R.id.Hindu);
        this.Budha = (RadioButton) findViewById(R.id.Budha);
        this.idKepercayaan= (RadioButton) findViewById(R.id.idKepercayaan);
        this.rNamaError = (TextInputLayout) findViewById(R.id.DNamaError);
        this.rAlamatError = (TextInputLayout) findViewById(R.id.DNamaError);
        this.DaftEmailError = (TextInputLayout) findViewById(R.id.DafEmailError);
        this.DrepassError = (TextInputLayout) findViewById(R.id.DrepwError);
        this.DaftPassError = (TextInputLayout) findViewById(R.id.DafPwError);
        this.butBatal = (Button) findViewById(R.id.btnBatal);
        this.butDaftar = (Button) findViewById(R.id.btnDaftar);
    }

    public void JenisAgama(View view) {
        int i = this.cekAgama;
        if (i == R.id.Islam) {
            this.agama = Islam;
        } else if (i == R.id.Katolik) {
            this.agama = Katolik;
        } else if (i == R.id.Kristen) {
            this.agama = Kristen;
        } else if (i == R.id.Konghucu) {
            this.agama = Konghucu;
        } else if (i == R.id.Hindu) {
            this.agama = Hindu;
        } else if (i == R.id.Budha) {
            this.agama = Budha;
        } else if (i == R.id.idKepercayaan) {
            this.ja = "Penganut Kepercayaan";
        }
    }

    public void JenisKelamin(View view) {
        int i = this.cekKelamin;
        if (i == R.id.Laki) {
            this.jk = "Laki-Laki";
        } else if (i == R.id.Perempuan) {
            this.jk = "Perempuan";
        }
    }

    public void validasi(View view) {
        if (this.rNama.getText().toString().isEmpty() || rAlamat.getText().toString().isEmpty()
                || rEmail.getText().toString().isEmpty() || rPass.getText().toString().isEmpty()
                || rrepass.getText().toString().isEmpty() || agama.getText().toString().isEmpty() || jeniskelamin.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Data Harus Diisi Semua", Toast.LENGTH_LONG).show();
        }
        if (rNama.getText().toString().isEmpty()) {
            rNamaError.setError("Nama Tidak Boleh Kosong");
            NamaValid = false;
        } else {
            rNamaError.setErrorEnabled(false);
            NamaValid = true;
        }
        if (rAlamat.getText().toString().isEmpty()) {
            rAlamatError.setError("Alamat Tidak Boleh Kosong");
            AlamatValid = false;
        } else {
            rAlamatError.setErrorEnabled(false);
            AlamatValid = true;
        }
        if (rEmail.getText().toString().isEmpty()) {
            DaftEmailError.setError("Email Tidak Boleh Kosong");
            EmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(rEmail.getText().toString()).matches()) {
            DaftEmailError.setError("Harap Masukkan Email Dengan Benar");
            EmailValid = false;
        } else {
            EmailValid = true;
            DaftEmailError.setErrorEnabled(false);
        }
        if (rPass.getText().toString().isEmpty()) {
            DaftPassError.setError("Password Tidak Boleh Kosong");
            PasswordValid = false;
        } else if (this.rPass.getText().length() < 6) {
            DaftPassError.setError("Panjang Password Minimal 6 Karakter");
            PasswordValid = false;
        } else {
            PasswordValid = true;
            DaftPassError.setErrorEnabled(false);
        }
        if (rrepass.getText().toString().isEmpty()) {
            DrepassError.setError("Re-Password Tidak Boleh Kosong!!!");
            RePasswordValid = false;
        } else if (rrepass.getText().length() < 6) {
            DrepassError.setError("Panjang Re-Password Minimal 6 Karakter!!!");
            RePasswordValid = false;
        } else if (!rrepass.getText().toString().equals(rPass.getText().toString())) {
            DrepassError.setError("Password Tidak Sama!!!");
            RePasswordValid = false;
        } else {
            RePasswordValid = true;
            DrepassError.setErrorEnabled(false);
        }
        if (NamaValid && AlamatValid && EmailValid && PasswordValid && RePasswordValid
                && !agama.getText().toString().isEmpty() && !jeniskelamin.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}