package es.itrafa.u6_student_rafael;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(myToolbar);
        Objects.requireNonNull(myToolbar.getOverflowIcon()).setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        if(item.getItemId() == R.id.cameraOption){
            Toast.makeText(getApplicationContext(), "Pulsado elemento: " + item.getTitle().toString(),
                    Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId() == R.id.exit_option){
            Toast.makeText(getApplicationContext(), "Pulsado elemento: " + item.getTitle().toString(),
                    Toast.LENGTH_SHORT).show();
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }

    }
}