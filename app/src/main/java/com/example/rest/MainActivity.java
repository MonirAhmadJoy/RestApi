package com.example.rest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
    AlertDialog.Builder builder;
    EditText nametext, emailtext, passwordtext;
    TextView tv;
    Button btn;
    String url="http://192.168.43.110/api/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nametext=findViewById(R.id.nametext);
        emailtext=findViewById(R.id.emailtext);
        passwordtext=findViewById(R.id.passwordtext);

        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);

        builder = new AlertDialog.Builder(this);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                builder.setMessage("Do you want to register into our Flower Shop website?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                 processdata(nametext.getText().toString(), emailtext.getText().toString(), passwordtext.getText().toString());
                                 dialog.cancel();
//                                finish();
//                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
//                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("AlertDialogExample");
                alert.show();

            }
        });
    }

    public  void processdata(String name, String email, String password)
    {
        Call<responsemodel> call= apiController.getInstance()
                .getapi()
                .getregister(name,email,password);

        call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {
                responsemodel obj=response.body();
                tv.setText(obj.getMessage());
                nametext.setText("");
                emailtext.setText("");
                passwordtext.setText("");
            }

            @Override
            public void onFailure(Call<responsemodel> call, Throwable t) {
                tv.setText("something went wrong");
                nametext.setText("");
                emailtext.setText("");
                passwordtext.setText("");
            }
        });
//        Retrofit retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
//        myapii api=retrofit.create(myapii.class);
//        Call<modell>call=api.adddata(nametext.getText().toString(), emailtext.getText().toString(), passwordtext.getText().toString());
//        call.enqueue(new Callback<modell>() {
//            @Override
//            public void onResponse(Call<modell> call, Response<modell> response) {
//                nametext.setText("");
//                emailtext.setText("");
//                passwordtext.setText("");
//                modell obj=response.body();
//                tv.setText(obj.me);
////                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<modell> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
}
//import androidx.annotation.Dimension;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.graphics.Paint;
//import android.os.Bundle;
//import android.widget.TextView;
//
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class MainActivity extends AppCompatActivity
//{
//    TextView tv;
//    String url="https://jsonplaceholder.typicode.com/";
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        tv=(TextView)findViewById(R.id.tv);
//        tv.setText("");
//
//        Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        myapi api=retrofit.create(myapi.class);
//
//        Call<List<model>> call=api.getmodels();
//
//        call.enqueue(new Callback<List<model>>() {
//            @Override
//            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
//                List<model> data=response.body();
//                for(int i=0; i<data.size();i++)
//                    tv.append(" SL No:"+data.get(i).getId()+" \n Title :"+data.get(i).getTitle()+"\n\n\n");
//            }
//
//            @Override
//            public void onFailure(Call<List<model>> call, Throwable t) {
//
//            }
//        });
//
//    }
//}