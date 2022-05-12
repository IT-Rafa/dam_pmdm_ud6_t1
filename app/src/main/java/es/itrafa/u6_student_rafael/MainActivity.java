package es.itrafa.u6_student_rafael;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> activityResultLauncher;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolBar = findViewById(R.id.myToolBar);
        setSupportActionBar(myToolBar);

        activityResultLauncher =
                registerForActivityResult(new
                        ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Intent data = result.getData();
                        if (data.hasExtra("IsRandomNumEven")) {
                            if (data.getExtras().getBoolean("IsRandomNumEven")){
                                Toast.makeText(getApplicationContext(), getString(R.string.isEvenMsg) , Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getApplicationContext(), getString(R.string.isOddMsg) , Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), getString(R.string.msg_fail_check_even), Toast.LENGTH_SHORT).show();
                        }
                    } else
                        Toast.makeText(getApplicationContext(), getString(R.string.no_backbtn_used), Toast.LENGTH_SHORT).show();
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

        if(item.getItemId() == R.id.itemCamera){

        }else if (item.getItemId() == R.id.itemExit){
            finish();

        }else{
            Toast.makeText(getApplicationContext(), "raro, raro",
                    Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void ManageEventsMainActivity() {
        findViewById(R.id.btn_changeActivity).setOnClickListener(
                view -> {
                    int randomNum = (int) (Math.random() * 25 + 1);
                    String n = Integer.toString(randomNum);

                    TextView txt = findViewById(R.id.numTest);
                    txt.setText(n);

                    Intent intent = new Intent(getApplicationContext(),
                            ShowNumberActivity.class);

                    intent.putExtra("RandomNum", n);
                    activityResultLauncher.launch(intent);
                }
        );
        findViewById(R.id.btn_changeActivity).setOnLongClickListener(
                view -> {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + ""));
                    startActivity(intent);

                    return true;
                }
        );

    }
}