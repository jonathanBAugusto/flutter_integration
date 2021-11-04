package br.com.coopercard.addtoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends AppCompatActivity {
    public FlutterEngine flutterEngineCounter;
    public FlutterEngine flutterEngineJsonPresenter;
    private final String ENG_ID_COUNTER = "counter_app";
    private final String ENG_ID_JSON_PRESENTER = "json_presenter_app";
    private final String ROUTE_COUNTER = "/counter";
    private final String ROUTE_JSON_PRESENTER = "/json-presenter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupFlutterEngine();

        startActivities();
    }

    private void startActivities(){
        FlutterActivity.withCachedEngine(ENG_ID_COUNTER).build(this);
        FlutterActivity.withCachedEngine(ENG_ID_JSON_PRESENTER).build(this);
    }

    private void setupFlutterEngine(){
        setupFlutterEngineCounter();
        setupFlutterEngineJsonPresenter();
    }

    private void setupFlutterEngineCounter() {
        flutterEngineCounter = new FlutterEngine(this);

        flutterEngineCounter.getNavigationChannel().setInitialRoute(ROUTE_COUNTER);

        flutterEngineCounter.getDartExecutor().executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
        );

        FlutterEngineCache
                .getInstance()
                .put(ENG_ID_COUNTER, flutterEngineCounter);
    }

    private void setupFlutterEngineJsonPresenter() {
        flutterEngineJsonPresenter = new FlutterEngine(this);

        flutterEngineJsonPresenter.getNavigationChannel().setInitialRoute(ROUTE_JSON_PRESENTER);

        flutterEngineJsonPresenter.getDartExecutor().executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
        );

        FlutterEngineCache
                .getInstance()
                .put(ENG_ID_JSON_PRESENTER, flutterEngineJsonPresenter);
    }

    public void onClickBtnAppFlutter(View v) {
        startActivity(
                FlutterActivity.withCachedEngine(ENG_ID_COUNTER).build(this)
        );
    }

    public void onClickBtnJsonPresenter(View v){
        startActivity(
                FlutterActivity.withCachedEngine(ENG_ID_JSON_PRESENTER).build(this)
        );
    }
}
