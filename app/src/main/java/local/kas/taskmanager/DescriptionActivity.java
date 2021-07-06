package local.kas.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {

    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        getData();
    }

    private void getData() {
        task = (Task) getIntent().getExtras().getSerializable(MyConstants.KEY_BUNDLE);
        setData();
    }

    private void setData() {
        TextView textView = findViewById(R.id.textView);
        textView.setText(getTask().getDescription());
    }

    public Task getTask() {
        return task;
    }
}