package local.kas.taskmanager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewholder> {

    private final ArrayList<Task> myTasks;
    private final Context context;

    public TaskAdapter(Context context, ArrayList<Task> myTasks) {
        this.context = context;
        this.myTasks = myTasks;
    }

    static class MyViewholder extends RecyclerView.ViewHolder {
        TextView title, description;
        AppCompatImageView imageView;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
//            name = itemView.findViewById(R.id.name);
//            date = itemView.findViewById(R.id.date);
            title = itemView.findViewById(R.id.title);

            description = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public TaskAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_does, viewGroup, false);
        return new MyViewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.MyViewholder holder, int position) {
        holder.title.setText(myTasks.get(position).getName());
        holder.description.setText(myTasks.get(position).getDate());
//        holder.itemView.set
        boolean isLandscape = context.getResources().getConfiguration().
                orientation == Configuration.ORIENTATION_LANDSCAPE;
        holder.itemView.setOnClickListener(v -> {
            if (isLandscape) {
                MainActivity mainActivity = ((MainActivity) context);
                TextView textView = mainActivity.findViewById(R.id.textView);
                textView.setText(myTasks.get(position).getDescription());
            } else {
                startDescriptionActivity(position);
            }

        });

    }

    private void startDescriptionActivity(int position) {
        Task task = myTasks.get(position);
        Intent intent = new Intent(context, DescriptionActivity.class);
        intent.putExtra(MyConstants.KEY_BUNDLE, task);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return myTasks.size();
    }
}
