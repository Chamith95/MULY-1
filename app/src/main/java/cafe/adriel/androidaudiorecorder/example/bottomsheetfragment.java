package cafe.adriel.androidaudiorecorder.example;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class bottomsheetfragment extends BottomSheetDialogFragment {
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
        return inflater.inflate(R.layout.bottomnav_sheet, container, false);
    }

}
