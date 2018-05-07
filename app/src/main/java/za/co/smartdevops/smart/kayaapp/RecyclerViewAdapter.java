package za.co.smartdevops.smart.kayaapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by smart on 4/19/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private ArrayList<Model> dataset;
    private Context mContext;
    public RecyclerViewAdapter (ArrayList<Model> mlist, Context context) {
        this.dataset = mlist;
        this.mContext = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
