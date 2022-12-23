package com.example.pifalafatec;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pifalafatec.model.PostModel;
import com.example.pifalafatec.network.ApiInteface;
import com.example.pifalafatec.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText edtraOrEmail, edtPassword;
    private Button btnSubmit;

    private ProgressDialog progressDialog;
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
            public void onClick(View v) {
                sendData();
            }

        });

    }

    private void sendData() {
        progressDialog.setMessage("Post Data in progress ...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiInteface apiInteface = RetrofitClient.getRetrofit().create(ApiInteface.class);
        final PostModel postModel = new PostModel(edtraOrEmail.getText().toString(), edtPassword.getText().toString());
        Call<PostModel> call = apiInteface.postData(postModel);

        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                progressDialog.dismiss();
                if(response.body().getStatus() == 200){

                    Intent intent = new Intent(MainActivity.this, TesteActivity.class);
                    startActivity(intent);
                    //Toast.makeText(MainActivity.this, response.body().getStatus_message(), Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, response.body().getStatus_message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });

    }
}