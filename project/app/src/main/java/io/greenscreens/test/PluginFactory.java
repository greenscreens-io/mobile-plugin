package io.greenscreens.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public enum PluginFactory {
    ;

    private static final String CATEGORY = "io.greenscreens.PLUGIN";
    private static final Intent pluginIntent = new Intent(Intent.ACTION_SEND);
    private static List<ActivityInfo> packages ;

    static {
        pluginIntent.addCategory(CATEGORY);
    }

    public static void reload(Context context) {
        packages = PluginFactory.getPackages(context, pluginIntent);
    }

    public static List<ActivityInfo> getPackages(Context context, Intent intent) {

        List<ActivityInfo> data = new ArrayList<ActivityInfo>();
        PackageManager pm = context.getPackageManager();

        List<ResolveInfo> infos = pm.queryIntentActivities (intent, PackageManager.GET_RESOLVED_FILTER);

        for (ResolveInfo info : infos) {
            ActivityInfo activityInfo = info.activityInfo;
            IntentFilter filter = info.filter;
            if (filter != null && filter.hasAction(Intent.ACTION_SEND) && filter.hasCategory(CATEGORY)) {
                data.add(activityInfo);

                // This activity resolves my Intent with the filter I'm looking for
                /*
                String activityPackageName = activityInfo.packageName;
                String activityName = activityInfo.name;
                System.out.println("Activity "+activityPackageName + "/" + activityName);
                */
            }
        }

        return data;
    }

    public static void showList(final Activity context, final PluginListener listener) {

        final ArrayAdapter<ActivityInfo> adapter = new ChooserArrayAdapter(context, android.R.layout.select_dialog_item, android.R.id.text1, packages);

        new AlertDialog.Builder(context)
                .setTitle(R.string.app_name)
                .setAdapter(adapter, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item ) {
                        if (listener != null) {
                            ActivityInfo activityInfo = packages.get(item);
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                            listener.onSelect(intent);
                        }
                    }
                }).show();
    }

    public interface PluginListener {
        void onSelect(Intent intent);
    }
}
