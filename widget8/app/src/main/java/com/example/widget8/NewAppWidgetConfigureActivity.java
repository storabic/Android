package com.example.widget8;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.net.Uri;
import android.app.PendingIntent;
import java.util.prefs.Preferences;

import androidx.annotation.Nullable;

/**
 * The configuration screen for the {@link NewAppWidget NewAppWidget} AppWidget.
 */
public class NewAppWidgetConfigureActivity extends Activity {
    private static final String PREFS_NAME = "com.test.nhmonitor.NHwidget";
    private static final String PREF_PREFIX_KEY = "appwidget_";
    private NewAppWidgetConfigureActivity context;
    private int widgetID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_app_widget_configure);
        setResult(RESULT_CANCELED);
        context = this;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            widgetID =
                    extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                            AppWidgetManager.INVALID_APPWIDGET_ID);
            final AppWidgetManager widgetManager =
                    AppWidgetManager.getInstance(context);
            final RemoteViews views = new
                    RemoteViews(context.getPackageName(), R.layout.new_app_widget);
            final EditText editText = (EditText)
                    findViewById(R.id.appwidget_text);
            Button button = (Button) findViewById(R.id.add_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(editText.getText().toString()));
                    PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);
                    views.setOnClickPendingIntent(R.id.appwidget_text, pending);
                    widgetManager.updateAppWidget(widgetID, views);
                    Intent resultValue = new Intent();
                    resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                            widgetID);
                    setResult(RESULT_OK, resultValue);
                    finish();

                }
            });
        }
    }

    public NewAppWidgetConfigureActivity() {
        super();
    }

    // Write the prefix to the SharedPreferences object for this widget
    static void saveTitlePref(Context context, int appWidgetId, String text) {
        SharedPreferences.Editor prefs = context.getSharedPreferences(PREFS_NAME, 0).edit();
        prefs.putString(PREF_PREFIX_KEY + appWidgetId, text);
        prefs.apply();
    }

    // Read the prefix from the SharedPreferences object for this widget.
// If there is no preference saved, get the default from a resource
    static String loadTitlePref(Context context, int appWidgetId) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        String titleValue = prefs.getString(PREF_PREFIX_KEY + appWidgetId, null);
        if (titleValue != null) {
            return titleValue;
        } else {
            return context.getString(R.string.appwidget_text);
        }
    }

    static void deleteTitlePref(Context context, int appWidgetId) {
        SharedPreferences.Editor prefs = context.getSharedPreferences(PREFS_NAME, 0).edit();
        prefs.remove(PREF_PREFIX_KEY + appWidgetId);
        prefs.apply();
    }
}

