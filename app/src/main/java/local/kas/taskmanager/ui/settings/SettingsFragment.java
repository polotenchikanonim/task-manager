package local.kas.taskmanager.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import local.kas.taskmanager.R;


public class SettingsFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        showHomeWork(view);
        return view;
    }

    private void showHomeWork(View view) {


        view.findViewById(R.id.popupMenu).setOnClickListener(this::showPopupMenu);
    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
        popupMenu.inflate(R.menu.popupmenu);


        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.one) {
                Toast.makeText(getContext(),
                        "Вы выбрали шаблон 1",
                        Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.two) {
                Toast.makeText(getContext(),
                        "Вы выбрали шаблон 2",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(),
                        "Вы выбрали шаблон 3",
                        Toast.LENGTH_SHORT).show();
            }
            return false;
        });


        popupMenu.setOnDismissListener(menu -> Toast.makeText(getContext(), "onDismiss",
                Toast.LENGTH_SHORT).show());
        popupMenu.show();

    }

}