package es.itrafa.u6_student_rafael;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolBar = findViewById(R.id.myToolBar);
        setSupportActionBar(myToolBar);

        ActivityResultLauncher activityResultLauncher;

        registerForActivityResult(new
                ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bundle bundle = result.getData().getExtras();
                        Intent data = result.getData();

                    } else
                        Toast.makeText(getApplicationContext(), "Saliste de la actividad secundaria sin pulsar el botón Cerrar", Toast.LENGTH_SHORT).show();
                });
        ManageEventsMainActivity();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
        Toast.makeText(getApplicationContext(), "Pulsado elemento: " + item.getTitle().toString(),
                Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    private void ManageEventsMainActivity(){
        findViewById(R.id.btn_changeActivity).setOnClickListener(
                view -> {
                    int randomNum = (int)(Math.random() * 25 + 1);
                    String n=Integer.toString(randomNum);

                    TextView txt = (TextView) findViewById(R.id.numTest);
                    txt.setText(n);

                    Intent intent = new Intent(getApplicationContext(),
                            ShowNumberActivity.class);

                    intent.putExtra("randomNum", n);

                }
        );
    }
}