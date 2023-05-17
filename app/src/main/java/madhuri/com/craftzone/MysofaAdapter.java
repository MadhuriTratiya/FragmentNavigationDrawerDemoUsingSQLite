package madhuri.com.craftzone;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MysofaAdapter extends RecyclerView.Adapter<MysofaAdapter.MysofaViewHolder>
{
    Context context;
    ArrayList<sofa> sofaArrayList;

    public MysofaAdapter(Context context, ArrayList<sofa> sofaArrayList) {
        this.context = context;
        this.sofaArrayList = sofaArrayList;
    }

    @NonNull
    @Override
    public MysofaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sofaitem,parent,false);
        MysofaViewHolder viewHolder = new MysofaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MysofaViewHolder holder, int position) {

        sofa sofa = sofaArrayList.get(position);
        holder.sofaimage.setImageURI(Uri.parse(sofaArrayList.get(position).getImg()));
        holder.sofatxt.setText(sofaArrayList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return sofaArrayList.size();
    }

    public static class MysofaViewHolder extends RecyclerView.ViewHolder {

        ImageView sofaimage;
        TextView sofatxt;


        public MysofaViewHolder(@NonNull View itemView) {
            super(itemView);
            sofaimage = (ImageView) itemView.findViewById(R.id.sofaimage);
            sofatxt = (TextView) itemView.findViewById(R.id.sofatxt);
        }
    }
}
