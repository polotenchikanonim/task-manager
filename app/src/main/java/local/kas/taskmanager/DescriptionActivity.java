package local.kas.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;
// 1. Подумайте о функционале вашего приложения заметок. Какие экраны там могут быть, помимо
// основного со списком заметок? Как можно использовать меню и всплывающее меню в вашем приложении?
// Не обязательно сразу пытаться реализовать весь этот функционал, достаточно создать макеты и
// структуру, а реализацию пока заменить на заглушки или всплывающие уведомления (Toast).
// Используйте подход Single Activity для отображения экранов.
// 2. Создайте боковое навигационное меню для своего приложения и добавьте туда хотя бы один экран,
// например «Настройки» или «О приложении».
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