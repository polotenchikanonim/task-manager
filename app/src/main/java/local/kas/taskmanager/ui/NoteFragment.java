package local.kas.taskmanager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import local.kas.taskmanager.R;
import local.kas.taskmanager.Task;
import local.kas.taskmanager.ui.tasks.TasksFragment;


public class NoteFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        view.findViewById(R.id.add).setOnClickListener(v -> createNote(view));
        return view;
    }


    private void createNote(View v) {
        String title, description, date;

        EditText editText = v.findViewById(R.id.title);
        title = editText.getText().toString();

        editText = v.findViewById(R.id.description);
        description = editText.getText().toString();

        editText = v.findViewById(R.id.date);
        date = editText.getText().toString();
        Task task = new Task(title,description,date);
//         add task DB // извините нет времени стараться - скоро моё первое путешествие на мотоцикле
//         надо много чего купить много чего сделать, не смогу к сожалению даже присутствовать  на
//        заключительном уроке
        showTasksFragment();
    }

    private void showTasksFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(
                R.id.nav_host_fragment_content_main,  new TasksFragment()).commit();
    }
}