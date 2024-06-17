package sumago.androidipt.day10b2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {


    TextInputLayout txMobileLayout;
    TextInputLayout txPasswordLayout;

    Button btnLogin;

    TextView tvSignUp;


    TextInputEditText etMobile;
    TextInputEditText etPassword;

    MyPref myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        txMobileLayout = findViewById(R.id.txMobileLayout);
        txPasswordLayout = findViewById(R.id.txPasswordLayout);
        etMobile = findViewById(R.id.etMobile);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);
        myPref = new MyPref(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateFields()) {


                    String savedMobile= myPref.getMobile();
                    String savePassword= myPref.getPassword();

                    if(etMobile.getText().toString().trim().equals(savedMobile) && etPassword.getText().toString().trim().equals(savePassword)  )
                    {

                        myPref.setIsLogin(true);
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                    }else{
                        Toast.makeText(LoginActivity.this, "Credentials Did Not Match", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });


    }

    private boolean validateFields() {
        ArrayList<Boolean> list = new ArrayList<>();

        if (!etMobile.getText().toString().trim().isEmpty() && etMobile.getText().toString().trim().length() == 10) {
            list.add(true);
            txMobileLayout.setError(null);
        } else {
            list.add(false);
            txMobileLayout.setError("Enter Valid Mobile");
        }
        if (!etPassword.getText().toString().trim().isEmpty() && etPassword.getText().toString().trim().length() > 3) {
            list.add(true);
            txPasswordLayout.setError(null);
        } else {
            list.add(false);
            txPasswordLayout.setError("Enter Valid Password");
        }
        return !list.contains(false);
    }
}