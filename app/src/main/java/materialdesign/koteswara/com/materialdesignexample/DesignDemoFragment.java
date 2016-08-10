package materialdesign.koteswara.com.materialdesignexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by koteswara on 10/08/16.
 */
public class DesignDemoFragment extends Fragment{
    private static final String TAB_POSITION = "tab_position";
   public DesignDemoFragment(){

    }
    public static DesignDemoFragment newInstance(int tabPosition){

        DesignDemoFragment designDemoFragment=new DesignDemoFragment();

        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        designDemoFragment.setArguments(args);

        return  designDemoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        int tabPosition = args.getInt(TAB_POSITION);
        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            items.add("Tab #" + tabPosition + " item #" + i);
        }
        View v =  inflater.inflate(R.layout.fragment_list_view, container, false);
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new DesignDemoRecyclerAdapter(items));

        return v;
    }
}
