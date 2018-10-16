package cafe.adriel.androidaudiorecorder.example;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;




import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

public class bottomsheetfragment extends BottomSheetDialogFragment {
    NavigationView navigation;
    public bottomsheetfragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.bottomnav_sheet, container, false);
        NavigationView navigation1=v.findViewById(R.id.navigation_view);
        navigation1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.nav1) {
                    Toast.makeText(getActivity(), "Message option is pressed",
                            Toast.LENGTH_LONG).show();
                    return true;
                }

                if (id == R.id.nav2) {
                    Toast.makeText(getActivity(), "Instrument option is pressed",
                            Toast.LENGTH_LONG).show();
                    return true;
                }

                return true;
            }
        });
        return v;



    }



}


