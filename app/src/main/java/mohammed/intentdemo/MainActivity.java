package mohammed.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button submitBtn;
    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn = (Button) findViewById(R.id.submitBtn);
        nameEditText = (EditText) findViewById(R.id.nameEditText);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //moveToSecondActivity_FirstWay();  // Uncomment it to test the method.
                moveToSecondActivity_SecondWay();
            }
        });
    }

    /**
     * Using Bundle directly to store the data to be shared to the Target Activity.
     * */
    private void moveToSecondActivity_FirstWay() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        Bundle b = new Bundle();
        b.putString(Constants.KEY_NAME, nameEditText.getText().toString());
        b.putInt(Constants.KEY_AGE, 21);

        intent.putExtras(b);

        startActivity(intent);
    }

    /**
     * Using Intent reference to store data inside the Bundle so as to pass on to Target Activity.
     * So, here we are using Bundle Indirectly.
     */
    private void moveToSecondActivity_SecondWay() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        intent.putExtra(Constants.KEY_NAME, nameEditText.getText().toString());
        intent.putExtra(Constants.KEY_AGE, 21);

        startActivity(intent);
    }
}
