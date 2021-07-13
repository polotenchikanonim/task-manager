package local.kas.taskmanager.ui.tasks;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import local.kas.taskmanager.R;
import local.kas.taskmanager.Task;
import local.kas.taskmanager.TaskAdapter;
import local.kas.taskmanager.ui.NoteFragment;


public class TasksFragment extends Fragment {

    private ArrayList<Task> tasks;
    private TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        textView = view.findViewById(R.id.textView);
        view.findViewById(R.id.fab).setOnClickListener(v -> showNewNoteFragment());
        return view;

    }

    private void showNewNoteFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(
                R.id.nav_host_fragment_content_main,  new NoteFragment()).commit();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        tasks = new ArrayList<>();
        tasks.add(new Task("покодить", "хорошо покодить ночью", "01.01.2000"));
        tasks.add(new Task("покушать", "хорошо покушать", "01.01.2001"));
        tasks.add(new Task("покатать", "покатать на моте до мурманска и обратно", "15.07.2021"));
        TaskAdapter taskAdapter = new TaskAdapter(getContext(), tasks);
        RecyclerView myTasks = view.findViewById(R.id.myTasksRV);
        myTasks.setLayoutManager(new LinearLayoutManager(getContext()));
        myTasks.setAdapter(taskAdapter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        boolean isLandscape = getResources().getConfiguration().
                orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (isLandscape) {
            showDescriptionTask(0);
        }
    }

    public void showDescriptionTask(int index) {
        textView.setText(tasks.get(index).getDescription());
    }

}