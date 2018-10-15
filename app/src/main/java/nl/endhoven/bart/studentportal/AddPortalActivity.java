package nl.endhoven.bart.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPortalActivity extends AppCompatActivity {
    private EditText mTitleText;
    private EditText mUrlText;
    private Button mAddButton;

    private final String TITLE_TEXT = "Add Portal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);
        setTitle(TITLE_TEXT);

        //Initiate components
        mAddButton = findViewById(R.id.add_button);
        mUrlText = findViewById(R.id.edit_url);
        mTitleText = findViewById(R.id.edit_titel);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get Text from view
                String url = mUrlText.getText().toString();
                String titleText = mTitleText.getText().toString();

                //Create portalItem object with textfield elements.
                PortalItem newPortalItem = new PortalItem(titleText, url);

                Intent resultIntent = new Intent();
                resultIntent.putExtra(MainActivity.PORTAL, (Parcelable) newPortalItem);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();

            }
        });
    }
}