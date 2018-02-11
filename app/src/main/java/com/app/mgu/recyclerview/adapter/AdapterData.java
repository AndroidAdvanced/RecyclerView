package com.app.mgu.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.app.mgu.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 123 on 2/11/2018.
 */
public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_child, parent, false);
        return new ViewHolder(inflater);
    }

    MOdel m ;

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        System.out.println("BindViewHolder");
        holder.txtView.setText("Temp..");
       // holder.chkBox.setOnCheckedChangeListener(new a());

        m = listModel.get(position);

        holder.chkBox.setChecked(m.isChhk);
        holder.chkBox.setOnCheckedChangeListener(new a(position));

    }

    @Override
    public int getItemCount() {
        return 100;
    }

   // List<Boolean> listChecked = new ArrayList<Boolean>();
   List<MOdel> listModel = new ArrayList<MOdel>();

   public AdapterData() {

        for(int i = 0 ; i < 100 ; i++) {
            MOdel m = new MOdel();
            m.isChhk = false;
            listModel.add(m);
        }
    }

    public class a implements CheckBox.OnCheckedChangeListener {

        int position;

        a(int posi) {
            this.position = posi;
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            listModel.get(position).isChhk = !isChecked;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

       @BindView(R.id.txtView)
       TextView txtView;

       @BindView(R.id.chkBox)
       CheckBox chkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
