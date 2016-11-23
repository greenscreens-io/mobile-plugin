/**
 * Copyright (C) 2015, 2016  Green Screens Ltd.
 */
package io.greenscreens.plugintest;

/**
 * Intent extra parameters for GeenScreens Web Terminal
 *
 * NOTE:
 * For Activity to be visible in terminal plugin selection list,
 * specific intent filter should be set in manifest file
 *
 * Please look at AndroidManifest.xml of this demo
 *
 *  <intent-filter>
 *      <action android:name="android.intent.action.SEND" />
 *      <category android:name="io.greenscreens.PLUGIN" />
 *  </intent-filter>
 *
 */
public enum Constants {
    ;

    // Intent request/response code
    public static final int IO_GREENSCREENS_CODE = 99;

    // Property contains returned value (must be string)
    public static final String IO_GREENSCREENS_VALUE = "io.greenscreens.VALUE";

    // Operation mode - PASTE to terminal or TRIGGER event in web terminal
    public static final String IO_GREENSCREENS_MODE = "io.greenscreens.MODE";

    // Type of mode.
    // If paste use one of paste modes bellow
    // If trigger, value will be the name of a nevet to be triggered
    public static final String IO_GREENSCREENS_TYPE = "io.greenscreens.TYPE";

    // valid only for paste mode, if set to 1 pasted value will be auto submited
    public static final String IO_GREENSCREENS_AUTO_SUBMIT = "io.greenscreens.AUTO_SUBMIT";

    // one of operation modes
    public static final String IO_GREENSCREENS_MODE_PASTE = "io.greenscreens.PASTE";
    public static final String IO_GREENSCREENS_MODE_TRIGGER = "io.greenscreens.TRIGGER";

    // one of paste modes (currently ony NA available)
    // NA means that paste mode is determined by current terminal paste mode
    // oter modes will override user selection
    public static final String IO_GREENSCREENS_TYPE_PASTE_NA = "NA";
    public static final String IO_GREENSCREENS_TYPE_PASTE_CF = "CF";
    public static final String IO_GREENSCREENS_TYPE_PASTE_CT = "CT";
    public static final String IO_GREENSCREENS_TYPE_PASTE_CE = "CE";
    public static final String IO_GREENSCREENS_TYPE_PASTE_BT = "BT";
    public static final String IO_GREENSCREENS_TYPE_PASTE_BE = "BE";

}
