package es.itrafa.u6_student_rafael;

import es.itrafa.u6_student_rafael.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_number);

        Toolbar myToolBar = findViewById(R.id.myToolBar);
        setSupportActionBar(myToolBar);

        Intent intent = getIntent();
        TextView txtView_showNumber = findViewById(R.id.txtView_showNumber);


        txtView_showNumber.setText(getString(R.string.randomNumMsg) + " "
                + intent.getExtras().getString("RandomNum"));

        ManageEventsShowNumberActivity();
    }

    private void ManageEventsShowNumberActivity() {
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnIntent = new Intent();
                int num = Integer.parseInt(getIntent().getExtras().getString("RandomNum"));
                boolean result;
                if (num % 2 == 0) {
                    result = true;
                } else {
                    result = false;
                }
                returnIntent.putExtra("IsRandomNumEven",
                        result);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });


    }
}
