package mohammed.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textViewName = (TextView) findViewById(R.id.nameid);
        TextView textViewAge = (TextView) findViewById(R.id.ageid);
        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
            }
        });
        Intent intent = getIntent();        // Get the reference to the incoming Intent object.
        Bundle b = intent.getExtras();      // Extract the Bundle residing inside the Intent.

        if (b.containsKey(Constants.KEY_NAME)) { // Just to be Safe
            String name = b.getString(Constants.KEY_NAME, "my default name");
            textViewName.setText(name);
           // Log.i(TAG, "Name : " + name);
        }
        if (b.containsKey(Constants.KEY_AGE)) { // Just to be safe
            int age = b.getInt(Constants.KEY_AGE, 30);
            textViewAge.setText(String.valueOf(age)+" years old");
        }

    }
}
