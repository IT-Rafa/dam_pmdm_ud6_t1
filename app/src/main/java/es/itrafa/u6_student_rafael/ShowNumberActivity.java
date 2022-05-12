package es.itrafa.u6_student_rafael;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_number);

        Toolbar myToolBar = findViewById(R.id.myToolBar);
        setSupportActionBar(myToolBar);

        Intent intent = getIntent();
        TextView txtView_showNumber = (TextView) findViewById(R.id.txtView_showNumber);


        txtView_showNumber.setText(getString(R.string.randomNumMsg) + " "
                + intent.getExtras().getString("randomNum"));
    }
}