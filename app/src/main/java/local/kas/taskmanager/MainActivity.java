package local.kas.taskmanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;


// 1. Создайте класс данных со структурой заметок: название заметки, описание заметки, дата создания
// и т. п.

// 2. Создайте фрагмент для вывода этих данных.

// 3. Встройте этот фрагмент в активити. У вас должен получиться экран с заметками, который мы будем
// улучшать с каждым новым уроком.

// 4. Добавьте фрагмент, в котором открывается заметка. По аналогии с примером из урока: если нажать
// на элемент списка в портретной ориентации — открывается новое окно, если нажать в ландшафтной —
// окно открывается рядом.


// 1. Подумайте о функционале вашего приложения заметок. Какие экраны там могут быть, помимо
// основного со списком заметок? Как можно использовать меню и всплывающее меню в вашем приложении?
// Не обязательно сразу пытаться реализовать весь этот функционал, достаточно создать макеты и
// структуру, а реализацию пока заменить на заглушки или всплывающие уведомления (Toast).
// Используйте подход Single Activity для отображения экранов.

// 2. Создайте боковое навигационное меню для своего приложения и добавьте туда хотя бы один экран,
// например «Настройки» или «О приложении».

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_notes,
                R.id.nav_settings
        ).setOpenableLayout(drawer).build();
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}