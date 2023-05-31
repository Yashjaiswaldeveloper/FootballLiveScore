package com.livetv.footballscore.livescores.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;

public abstract class BasicListAdapter<X, T extends ViewHolder> extends RecyclerView.Adapter<T> {
    ArrayList<X> elements = new ArrayList<>();
    ArrayList<X> secondList = new ArrayList<>();

    public int getItemViewType(int i) {
        return i;
    }

    public abstract void onBindViewHolder(T t, int i);

    public abstract T onCreateViewHolder(ViewGroup viewGroup, int i);

    public BasicListAdapter(ArrayList<X> arrayList) {
        this.elements = arrayList;
    }

    public BasicListAdapter(ArrayList<X> arrayList, ArrayList<X> arrayList2) {
        this.elements = arrayList;
        this.secondList = arrayList2;
    }

    public int getItemCount() {
        return this.elements.size();
    }
}
