package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button btnSignin;
    TextInputLayout emailError,passError;
    EditText edEmail,edPassword;
    TextView Daftar;
    boolean mailvalid,passvalid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignin = findViewById(R.id.btnSignin);
        emailError = findViewById(R.id.emailError);
        passError = findViewById(R.id.passError);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        Daftar = findViewById(R.id.Daftar);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edEmail.getText().toString().isEmpty()){
                    emailError.setError("Email Tidak Boleh Kosong");
                    mailvalid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(edEmail.getText().toString()).matches()){
                    emailError.setError("Masukkan Email dengan Benar");
                    mailvalid = false;
                }else  {
                    mailvalid = true;
                    emailError.setErrorEnabled(false);
                }
                if (edPassword.getText().toString().isEmpty()){
                    passError.setError("Password Tidak Boleh Kosong");
                    passvalid = false;
                } else if (edEmail.getText().length() <6) {
                    emailError.setError("Minimal 6 karakter");
                    mailvalid = false;
                }else  {
                    passvalid = true;
                    passError.setErrorEnabled(false);
                }
                if (!mailvalid || !passvalid || !edEmail.getText().toString().equals("admin@gmial.com") || !edPassword.getText().toString().equals("123456")){
                    Toast.makeText(getApplicationContext(),"Email atau Password Salah !!!", Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(getApplicationContext(),"Login Sukses",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),Home_Activity.class));
            }
        });
        
        Daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(),Pendaftaran.class));
            }
        });
    }
}