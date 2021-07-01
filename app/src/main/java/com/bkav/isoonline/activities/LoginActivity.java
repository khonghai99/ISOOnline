package com.bkav.isoonline.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bkav.isoonline.R;
import com.bkav.isoonline.Session.Golobal;
import com.bkav.isoonline.Session.Session;
import com.bkav.isoonline.models.User;
import com.bkav.isoonline.models.UserModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class LoginActivity extends AppCompatActivity {

    private Button mButtonLogin;
    private EditText calculator;
    private EditText Account;
    private EditText passWord;
    private EditText idas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mButtonLogin = findViewById(R.id.button_login);
        calculator = findViewById(R.id.text_key_login);
        Account = findViewById(R.id.text_user);
        passWord = findViewById(R.id.text_pass);
        idas = findViewById(R.id.text_id_das);
        int x = 0 + (int)(Math.random() * ((10 - 0) + 1));
        int y = 0 + (int)(Math.random() * ((10 - 0) + 1));
        calculator.setHint(String.valueOf(x) + " + " + String.valueOf(y));

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check login in here
                String account = Account.getText().toString();
                String pass = passWord.getText().toString();
                String maIdas = idas.getText().toString();
                String resultCalcul = calculator.getText().toString();

                if(account.equals("")){
                    Toast.makeText(LoginActivity.this, "Bạn chưa nhập tài khoản", Toast.LENGTH_LONG).show();
                    Account.requestFocus();
                }
                else {
                    if(pass.equals("")){
                        Toast.makeText(LoginActivity.this, "Bạn chưa nhập mật khẩu", Toast.LENGTH_LONG).show();
                        passWord.requestFocus();
                    }
                    else {
                        if(maIdas.equals("")){
                            Toast.makeText(LoginActivity.this, "Bạn chưa nhập mã Idas", Toast.LENGTH_LONG).show();
                            idas.requestFocus();
                        }
                        else {
                            if(resultCalcul.equals("")){
                                Toast.makeText(LoginActivity.this, "Bạn chưa nhập kết quả", Toast.LENGTH_LONG).show();
                                calculator.requestFocus();
                            }
                            else {
                                if(Integer.valueOf(resultCalcul) != (x + y)){
                                    Toast.makeText(LoginActivity.this, "Kết quả không đúng", Toast.LENGTH_LONG).show();
                                    calculator.requestFocus();
                                    calculator.getBackground().mutate().setColorFilter(getResources().getColor(android.R.color.holo_red_light), PorterDuff.Mode.SRC_ATOP);
                                }
                                else {
                                    try {
                                        UserModel model = new UserModel();
                                        List<User> lst =  model.getuserlist(account,pass,maIdas);
                                        if(lst.size() > 0){
                                            Golobal.setIdUser(lst.get(0).getID());
                                            Golobal.setNameUser(lst.get(0).getName());
                                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                            finish();
                                        }
                                    } catch (SQLException throwables) {
                                        throwables.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}