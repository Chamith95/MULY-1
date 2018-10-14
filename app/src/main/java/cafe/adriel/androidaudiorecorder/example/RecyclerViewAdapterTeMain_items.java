package cafe.adriel.androidaudiorecorder.example;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapterTeMain_items extends RecyclerView.Adapter<RecyclerViewAdapterTeMain_items.ExampleViewHolder3> {
    private ArrayList<teacherM_card_item> tStuList;
    private OnItemClickListner tListner;

    public interface OnItemClickListner{
        void onItemclick(int position);
    }

    public void setOnItemClickListner(OnItemClickListner listner){
        tListner=listner;

    }

    public static class ExampleViewHolder3 extends RecyclerView.ViewHolder{

        public ImageView tImageView;
        public ImageView tImageView2;
        public TextView tTextView;

        public ExampleViewHolder3(final View itemView, final OnItemClickListner listner) {
            super(itemView);
            tImageView=itemView.findViewById(R.id.studentimage);
            tImageView2=itemView.findViewById(R.id.graphView);
            tTextView=itemView.findViewById(R.id.studenttext1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { //Automatic change
                    if(listner !=null){
                        int position=getAdapterPosition();
                        if(position !=RecyclerView.NO_POSITION){
                            listner.onItemclick(position);
                        }

                    }
                    itemView.getContext().startActivity(new Intent(v.getContext(),teachercardtest.class));
                }
            });
        }
    }

    public  RecyclerViewAdapterTeMain_items(ArrayList<teacherM_card_item> itemlist){
        tStuList=itemlist;
    }

    @NonNull
    @Override
    public ExampleViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.teacherm_student_item,parent,false);
        ExampleViewHolder3 evh1=new ExampleViewHolder3(v,tListner);
        return evh1;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder3 holder, int position) {
            teacherM_card_item currentItem=tStuList.get(position);

            holder.tImageView.setImageResource(currentItem.getmImagerResource4());
            holder.tImageView2.setImageResource(currentItem.getmImagerResource5());
            holder.tTextView.setText(currentItem.getmText4());
    }

    @Override
    public int getItemCount() {
        return tStuList.size();
    }
}
