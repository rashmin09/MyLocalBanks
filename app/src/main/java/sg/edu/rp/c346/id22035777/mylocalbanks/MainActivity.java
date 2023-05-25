package sg.edu.rp.c346.id22035777.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDbs, tvOcbc, tvUob;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.tvDbs);
        tvOcbc = findViewById(R.id.tvOcbc);
        tvUob = findViewById(R.id.tvUob);

        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Contact the bank");
        menu.add(0, 1, 1, "Website");

        if (v == tvDbs){
            wordClicked = "dbs";
        }
        else if (v == tvOcbc){
            wordClicked = "ocbc";
        }
        else if (v == tvUob){
            wordClicked = "uob";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobNo)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uobUrl)));
                startActivity(intent);
                return true;
            }
        }
        else if(wordClicked.equalsIgnoreCase("ocbc")){
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobNo)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uobUrl)));
                startActivity(intent);
                return true;
            }
        }
        else if(wordClicked.equalsIgnoreCase("uob")){
            if (item.getItemId() == 0) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobNo)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uobUrl)));
                startActivity(intent);
                return true;
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
    @Override
            public boolean onCreateOptionsMenu(Menu menu){
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
            }
            @Override
            public boolean onOptionsItemSelected(MenuItem item){
                // Handle action bar item clicks here.
                int id = item.getItemId();

                if (id == R.id.english) {
                    tvDbs.setText(getString(R.string.dbsEnglish));
                    tvOcbc.setText(getString(R.string.ocbcEnglish));
                    tvUob.setText(getString(R.string.uobEnglish));
                    return true;
                } else if (id == R.id.chinese) {
                    tvDbs.setText(getString(R.string.dbsChinese));
                    tvOcbc.setText(getString(R.string.ocbcChinese));
                    tvUob.setText(getString(R.string.uobChinese));
                    return true;
                } else {
                    tvDbs.setText("Error translation");
                    tvOcbc.setText("Error translation");
                    tvUob.setText("Error translation");
                }
                return super.onOptionsItemSelected(item);
            }
        }
