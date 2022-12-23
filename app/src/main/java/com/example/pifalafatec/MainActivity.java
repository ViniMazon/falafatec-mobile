package com.example.pifalafatec;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pifalafatec.model.PostModel;
import com.example.pifalafatec.network.ApiInterface;
import com.example.pifalafatec.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText edtraOrEmail, edtPassword;
    private Button btnSubmit;
    private ProgressDialog progressDialog;
    private TextView txtTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtraOrEmail = findViewById(R.id.edtRE);
        edtPassword = findViewById(R.id.edtPass);
        btnSubmit = findViewById(R.id.btnLogin);
        progressDialog = new ProgressDialog(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sendData();
                sendData();
            }
        });


    }

    private void sendData() {

        progressDialog.setMessage("Validando usuário...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiInterface apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        final PostModel postModel = new PostModel(edtraOrEmail.getText().toString(), edtPassword.getText().toString());
        Call<PostModel> call = apiInterface.postData(postModel);

        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                progressDialog.dismiss();
                if (!response.isSuccessful()) {
                    //Toast.makeText(MainActivity.this, response.body().getStatus_Message(), Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(MainActivity.this, response.body().getStatus_Message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                progressDialog.dismiss();
                Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
                startActivity(intent);
                 //Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}


