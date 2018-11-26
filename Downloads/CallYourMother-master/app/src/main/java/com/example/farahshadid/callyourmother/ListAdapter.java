package com.example.farahshadid.callyourmother;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<String> names;
    SparseBooleanArray selected;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView icon;
        CheckBox check;
        ConstraintLayout layout;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            icon = itemView.findViewById(R.id.icon);
            check = itemView.findViewById(R.id.checkbox);
            layout = itemView.findViewById(R.id.layout);
        }
    }

    public int getSelected() {
        return selected.size();
    }

    ListAdapter(ArrayList<String> name) {
        names = name;

        selected = new SparseBooleanArray();
        Collections.sort(names);
    }


    @Override
    public int getItemCount() {
        return names.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_element, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(names.get(i));
        viewHolder.check.setChecked(selected.get(i));
        viewHolder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewHolder.check.isChecked()) {
                    selected.put(i, true);
                } else {
                    selected.delete(i);
                }
            }
        });

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.check.toggle();
                if (viewHolder.check.isChecked()) {
                    selected.put(i, true);
                } else {
                    selected.delete(i);
                }
            }
        });
    }
}