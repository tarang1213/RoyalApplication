package com.royalapplication.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.royalapplication.R;

public class MainActivity extends AppCompatActivity {
    EditText edtEmail,edtPassword;
    Button btnLogin;
    ImageView imgLogo;
    Button btnFp;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.edt_email);
        btnLogin = findViewById(R.id.btn_login);
        imgLogo  = findViewById(R.id.img_logo);
        btnFp = findViewById(R.id.btn_fp);
        edtPassword=findViewById(R.id.edt_password);

        btnFp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View fpView = layoutInflater.inflate(R.layout.raw_fp, null);
                EditText edtFPEmail = fpView.findViewById(R.id.edt_fp);
                Button btnSubmit = fpView.findViewById(R.id.btn_submit);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                AlertDialog alertDialog = builder.create();
                alertDialog.setView(fpView);
                alertDialog.show();

                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Submit", Toast.LENGTH_SHORT).show();

                        if (alertDialog.isShowing()) {

                            alertDialog.dismiss();
                        }
                    }
                });
            }
        });



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail = edtEmail.getText().toString();
                String strPassword=edtPassword.getText().toString();
                if (strEmail.equals("")){
                    edtEmail.setError("Enter Email ID");
//                    Toast.makeText(MainActivity.this, "Enter Email ID ", Toast.LENGTH_SHORT).show();
                }else if(!strEmail.matches(emailPattern)){
                    edtEmail.setError("Enter valid Email ID");
//                    Toast.makeText(MainActivity.this, "Enter valid Email ID ", Toast.LENGTH_SHORT).show();
                }else if(strPassword.equals("")){
                    edtPassword.setError("Enter password");
//                    Toast.makeText(MainActivity.this, "Enter password ", Toast.LENGTH_SHORT).show();
                }
                else if(strPassword.length()<8){
                    edtPassword.setError("Enter valid password");
//                    Toast.makeText(MainActivity.this, "Enter valid password ", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Email ID is  "+strEmail, Toast.LENGTH_SHORT).show();
                    imgLogo.setImageResource(R.drawable.icon_2);

                    Intent i = new Intent(MainActivity.this,HomeActivity.class);
                    i.putExtra("KEY_EMAIL",strEmail);
                    startActivity(i);

                }
            }
        });
    }
}