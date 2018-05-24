package com.example.nikhil.pdf1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by NIKHIL on 22-05-2018.
 */

public class IntentHandle extends Activity {

    TextView mtextView;

  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      mtextView = findViewById(R.id.textView);

      //Get Intent, action and MIME type
      Intent intent = getIntent();
      String action = intent.getAction();
      String type = intent.getType();


      if (Intent.ACTION_SEND.equals(action) && type != null) {
          if ("text/plain".equals(type)) {
              handleSendText(intent); // Handle text being sent
          }else
              {
                  handleSendText(intent);
              }

  }
  else
      {
          Toast.makeText(getApplicationContext(),"Hey Check URL",Toast.LENGTH_LONG).show();
      }

  }

    void handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) {

            mtextView.setText(sharedText);
            // Update UI to reflect text being shared

        }
    }

}
