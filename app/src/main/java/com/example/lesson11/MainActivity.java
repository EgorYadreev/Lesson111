package com.example.lesson11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private TextView loginLocker;
    private TextView attempts;
    private TextView numberOfAttempts;
    int numberOfRemainingLoginAttempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.edit_user);
        password = (EditText) findViewById(R.id.edit_password);
        login = (Button) findViewById(R.id.button_login);
        loginLocker = (TextView) findViewById(R.id.login_locker);
        attempts = (TextView) findViewById(R.id.attempts);
        numberOfAttempts = (TextView) findViewById(R.id.number_of_attempts);
        numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts))
    }
    public void Login(View view) {
        if (username.getText().toString().equals("admin")&& password.getText().toString().equals("admin")){
            Toast.makeText(getApplicationContext(),"Вход выполнен!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,Second.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"Неправильные данные!",Toast.LENGTH_SHORT).show();
            numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));

            if (numberOfRemainingLoginAttempts == 0){
                login.setEnabled(false);
                loginLocker.setVisibility(View.VISIBLE);
                loginLocker.setBackgroundColor(Color.RED);
                loginLocker.setText("Вход заблокирован!");
            }
        }
    }
}