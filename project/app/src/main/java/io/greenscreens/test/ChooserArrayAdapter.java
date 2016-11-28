package io.greenscreens.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ChooserArrayAdapter extends ArrayAdapter<ActivityInfo> {

    PackageManager mPm;
    int mTextViewResourceId;
    List<ActivityInfo> mPackages;
    Map<String, ApplicationInfo> mApplicationInfoList;

    public ChooserArrayAdapter(Context context, int resource, int textViewResourceId, List<ActivityInfo> packages) {
        super(context, resource, textViewResourceId, packages);
        mPm = context.getPackageManager();
        mTextViewResourceId = textViewResourceId;
        mPackages = packages;
        mApplicationInfoList = new HashMap<>();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ActivityInfo pkg = mPackages.get(position);
        View view = super.getView(position, convertView, parent);

        try {
            ApplicationInfo ai = mApplicationInfoList.get(pkg.packageName);
            if (ai == null) {
                ai = mPm.getApplicationInfo(pkg.packageName, 0);
                mApplicationInfoList.put(pkg.packageName, ai);
            }

            CharSequence appName = mPm.getApplicationLabel(ai);
            Drawable appIcon = mPm.getApplicationIcon(pkg.packageName);

            TextView textView = (TextView) view.findViewById(mTextViewResourceId);
            textView.setText(appName);
            textView.setCompoundDrawablesWithIntrinsicBounds(appIcon, null, null, null);
            textView.setCompoundDrawablePadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getContext().getResources().getDisplayMetrics()));
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }

        return view;
    }

}
