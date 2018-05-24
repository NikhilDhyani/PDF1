package com.example.nikhil.pdf1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button convertbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText  = findViewById(R.id.ed);
        convertbtn = findViewById(R.id.btn);

        convertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertPDF();
            }
        });
    }

    public void convertPDF()
    {
        String url = editText.getText().toString();
        if (url.equals(""))
        {
            Toast.makeText(getApplicationContext(),"No URL FOund",Toast.LENGTH_LONG).show();
        }else
            {
                new convertnow().execute(url);
            }



    }

    private class convertnow extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... strings) {

            String url = strings[0];

             BackgroundTask myTask = new BackgroundTask();

             myTask.doWebViewPrint();

            return url;
        }

        @Override
        protected void onPostExecute(String s) {


            super.onPostExecute(s);

           Toast.makeText(getApplicationContext(),"In Background",Toast.LENGTH_LONG).show();
        }
    }

}
