package com.example.fivelesson;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskFragmentAdapter extends RecyclerView.Adapter<TaskFragmentAdapter.TaskViewHolder> {
    public List<TaskModel> list;
    TaskModel taskModel;

    public TaskFragmentAdapter(List<TaskModel> list) {
        this.list = list;
    }


    public void addData(TaskModel taskModell) {
        list.add(taskModell);
        notifyDataSetChanged();

    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskFragmentAdapter.TaskViewHolder holder, int position) {
        holder.txttitle.setText(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView txttitle;

        public TaskViewHolder(View itemView) {
            super(itemView);
            txttitle = itemView.findViewById(R.id.item_title_txt);
        }

    }

}
