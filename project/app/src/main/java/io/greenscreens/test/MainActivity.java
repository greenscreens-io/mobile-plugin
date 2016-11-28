package io.greenscreens.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PluginFactory.reload(this);
    }

    public void onPlugins(View v) {

        PluginFactory.showList(this, new PluginFactory.PluginListener() {
            @Override
            public void onSelect(Intent intent) {
                MainActivity.this.startActivityForResult(intent, Constants.IO_GREENSCREENS_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (Constants.IO_GREENSCREENS_CODE == requestCode && requestCode == resultCode) {
            String value = data.getStringExtra(Constants.IO_GREENSCREENS_VALUE);
            if (value != null) {
                Toast.makeText(this, "Response :" + value, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
