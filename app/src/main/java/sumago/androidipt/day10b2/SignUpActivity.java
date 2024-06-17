package sumago.androidipt.day10b2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    TextInputLayout txNameLayout;
    TextInputLayout txMobileLayout;
    TextInputLayout txPasswordLayout;
    TextInputLayout txConfirmPasswordLayout;

    Button btnSignUp;

    TextView tvLogin;

    TextInputEditText etName;
    TextInputEditText etMobile;
    TextInputEditText etPassword;
    TextInputEditText etConfirmPassword;
    MyPref myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myPref=new MyPref(this);
        if(myPref.getIsLogin())
        {
            Intent intent=new Intent(SignUpActivity.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        setContentView(R.layout.activity_sign_up);
        txNameLayout=findViewById(R.id.txNameLayout);
        txMobileLayout=findViewById(R.id.txMobileLayout);
        txPasswordLayout=findViewById(R.id.txPasswordLayout);
        txConfirmPasswordLayout=findViewById(R.id.txConfirmPasswordLayout);
        etName=findViewById(R.id.etName);
        etMobile=findViewById(R.id.etMobile);
        etPassword=findViewById(R.id.etPassword);
        etConfirmPassword=findViewById(R.id.etConfirmPassword);
        btnSignUp=findViewById(R.id.btnSignUp);
        tvLogin=findViewById(R.id.tvLogin);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateFields())
                {
                    myPref.setName(etName.getText().toString().trim());
                    myPref.setMobile(etMobile.getText().toString().trim());
                    myPref.setPassword(etPassword.getText().toString().trim());
                    Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                    startActivity(intent);

                }
            }
        });


    }

    private boolean validateFields() {
        ArrayList<Boolean> list=new ArrayList<>();
        if(!etName.getText().toString().trim().isEmpty() && etName.getText().toString().trim().length()>3)
        {
            list.add(true);
            txNameLayout.setError(null);
        }else {
            list.add(false);
            txNameLayout.setError("Enter Valid Name");
        }
        if(!etMobile.getText().toString().trim().isEmpty() && etMobile.getText().toString().trim().length()==10)
        {
            list.add(true);
            txMobileLayout.setError(null);
        }else {
            list.add(false);
            txMobileLayout.setError("Enter Valid Mobile");
        }
        if(!etPassword.getText().toString().trim().isEmpty() && etPassword.getText().toString().trim().length()>3)
        {
            list.add(true);
            txPasswordLayout.setError(null);
        }else {
            list.add(false);
            txPasswordLayout.setError("Enter Valid Password");
        }

        if(!etPassword.getText().toString().trim().isEmpty() && etPassword.getText().toString().trim().equals(etConfirmPassword.getText().toString().trim()))
        {
            list.add(true);
            txPasswordLayout.setError(null);
            txConfirmPasswordLayout.setError(null);
        }else {
            list.add(false);
            txPasswordLayout.setError("Password Did Not Match");
            txConfirmPasswordLayout.setError("Password Did Not Match");
        }
        return !list.contains(false);
    }
}