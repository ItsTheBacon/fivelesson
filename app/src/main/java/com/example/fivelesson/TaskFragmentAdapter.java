package com.example.fivelesson;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskFragmentAdapter extends RecyclerView.Adapter<TaskFragmentAdapter.TaskViewHolder> {
    public List<TaskModel> list = new ArrayList<>();
    LayoutInflater layoutInflater;
    private ItemClickList onitemClickList;


    public void setItemClickList(ItemClickList itemClickList) {
        this.onitemClickList = itemClickList;
    }


    public TaskFragmentAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }


    public void EditData(int position, TaskModel model) {
        list.get(position).setTxttitle(model.getTxttitle());
        list.get(position).setDescrption(model.getDescrption());
        notifyDataSetChanged();
    }

    public void deleteTask(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskFragmentAdapter.TaskViewHolder holder, int position) {
        holder.bind(list.get(position));


    }

    public void addData(TaskModel taskModel) {
        this.list.add(taskModel);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView txttitle, txtDescription;

        public TaskViewHolder(View itemView) {
            super(itemView);
            txttitle = itemView.findViewById(R.id.item_title_txt);
            txtDescription = itemView.findViewById(R.id.item_txt_description);
        }

        public void bind(TaskModel taskModel) {
            txttitle.setText(taskModel.getTxttitle());
            txtDescription.setText(taskModel.getDescrption());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onitemClickList.CLickItem(getAdapterPosition(), taskModel);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog dialog = new AlertDialog.Builder(itemView.getContext()).create();
                    dialog.setTitle("Внимание!");
                    dialog.setMessage("Вы  точно хотите удалить ???");

                    dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Нет", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deleteTask(getAdapterPosition());
                        }
                    });
                    dialog.show();
                    return false;
                }
            });

        }
    }

}
