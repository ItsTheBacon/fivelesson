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
     List<TaskModel> list = new ArrayList<>();
    LayoutInflater layoutInflater;
    ItemClickList onitemClickList;



    public void setItemClickList(ItemClickList itemClickList) {
        this.onitemClickList = itemClickList;
    }


    public  TaskFragmentAdapter(Context context){
        this.layoutInflater = LayoutInflater.from(context);
    }



    public void addData(String title,String descrption) {
        list.add(0,new TaskModel(title, descrption));
        notifyDataSetChanged();

    }
    public void deleteTask(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_task, parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskFragmentAdapter.TaskViewHolder holder, int position) {
        holder.txttitle.setText(list.get(position).getTxttitle());
        holder.txtDescription.setText(list.get(position).getDescrption());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView txttitle , txtDescription;

        public TaskViewHolder(View itemView) {
            super(itemView);
            txttitle = itemView.findViewById(R.id.item_title_txt);
            txtDescription= itemView.findViewById(R.id.item_txt_description);
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
