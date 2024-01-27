package in.edu.ptuniv;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesViewAdapter extends RecyclerView.Adapter<NotesViewAdapter.ViewHolder> {
    private ArrayList<Note> notess = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtName.setText(notess.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), notess.get(position).getName() + " Selected", Toast.LENGTH_SHORT).show();
                // Perform additional actions if needed
                Context context = v.getContext();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(notess.get(position).getLink()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return notess.size();
    }

    public void setNotess(ArrayList<Note> notess) {
        this.notess = notess;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
        }
    }
}
