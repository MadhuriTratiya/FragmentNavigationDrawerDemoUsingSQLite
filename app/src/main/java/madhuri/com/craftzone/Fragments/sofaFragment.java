package madhuri.com.craftzone.Fragments;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import madhuri.com.craftzone.DatabaseHelper;
import madhuri.com.craftzone.MysofaAdapter;
import madhuri.com.craftzone.R;
import madhuri.com.craftzone.sofa;

public class sofaFragment extends Fragment {
    DatabaseHelper databaseHelper;
    RecyclerView recyclerView;

    View view;
    private RecyclerView myrecyclerView;
    private List<sofa> sofaList;

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view =  inflater.inflate(R.layout.sofafragment,container,false);
        myrecyclerView = (RecyclerView) view.findViewById(R.id.sofarecycler);
        MysofaAdapter mysofaAdapter = new MysofaAdapter(getContext(), (ArrayList<sofa>) sofaList);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(mysofaAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sofaList = new ArrayList<>();
        sofaList.add(new sofa(R.drawable.backmainscreen, "Craftzone Logo"));
        sofaList.add(new sofa(R.drawable.backmainscreen, "Craftzone Logo"));
        sofaList.add(new sofa(R.drawable.backmainscreen, "Craftzone Logo"));
        sofaList.add(new sofa(R.drawable.backmainscreen, "Craftzone Logo"));
        sofaList.add(new sofa(R.drawable.backmainscreen, "Craftzone Logo"));




    }
}
