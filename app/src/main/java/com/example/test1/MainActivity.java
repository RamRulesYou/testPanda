package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Button SignIn;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.nameLogin);
        Password = (EditText)findViewById(R.id.passLogin);
        Info = (TextView)findViewById(R.id.txtLogin);
        Login = (Button)findViewById(R.id.btnLogin);
        SignIn = (Button)findViewById(R.id.btnSignin);

        Info.setText("Number of attempts remaining is : 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validate(String userName, String userPass){

        if((userName.equals("ramu"))&&(userPass.equals("madhuri"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("Number of attempts remaining is : " + String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}