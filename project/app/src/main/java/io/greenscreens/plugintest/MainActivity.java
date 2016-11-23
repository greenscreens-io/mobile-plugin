/**
 * Copyright (C) 2015, 2016  Green Screens Ltd.
 */
package io.greenscreens.plugintest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Return value will trigger event inside terminal on Tn5250.Application object
     * This is intended for custom web terminal scripts
     *
     * Test example for web terminal script
     * Tn5250.Application.listen('test', function(value){alert(value)});
     *
     * @param v
     */
    public void onSendTrigger(View v) {
        if (getIntent() != null) {
            Intent intent = new Intent();
            intent.putExtra(Constants.IO_GREENSCREENS_MODE, Constants.IO_GREENSCREENS_MODE_TRIGGER);
            intent.putExtra(Constants.IO_GREENSCREENS_TYPE, "test");
            intent.putExtra(Constants.IO_GREENSCREENS_VALUE, "demo");

            setResult(Constants.IO_GREENSCREENS_CODE, intent);
            finish();
        }
    }

    /**
     * Return value will be pasted in focused web terminal field
     * @param v
     */
    public void onSendPaste(View v) {
        if (getIntent() != null) {
            Intent intent = new Intent();
            intent.putExtra(Constants.IO_GREENSCREENS_MODE, Constants.IO_GREENSCREENS_MODE_PASTE);
            intent.putExtra(Constants.IO_GREENSCREENS_TYPE, Constants.IO_GREENSCREENS_TYPE_PASTE_NA);
            intent.putExtra(Constants.IO_GREENSCREENS_VALUE, "demo");

            setResult(Constants.IO_GREENSCREENS_CODE, intent);
            finish();
        }
    }

    /**
     * Return value will be pasted in focused web terminal field.
     * After paste, automatic anter will be sent to terminal
     * @param v
     */
    public void onSendPasteAuto(View v) {
        if (getIntent() != null) {
            Intent intent = new Intent();
            intent.putExtra(Constants.IO_GREENSCREENS_MODE, Constants.IO_GREENSCREENS_MODE_PASTE);
            intent.putExtra(Constants.IO_GREENSCREENS_TYPE, Constants.IO_GREENSCREENS_TYPE_PASTE_NA);
            intent.putExtra(Constants.IO_GREENSCREENS_AUTO_SUBMIT, 1);
            intent.putExtra(Constants.IO_GREENSCREENS_VALUE, "demo");

            setResult(Constants.IO_GREENSCREENS_CODE, intent);
            finish();
        }
    }
}
