package cafe.adriel.androidaudiorecorder.example;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

import java.util.ArrayList;

public class TeacherMain extends AppCompatActivity {
    private ArrayList<teacherM_card_item> mactList;

    private RecyclerView tRecyclerView;
    private RecyclerViewAdapterTeMain_items tAdapter;
    private RecyclerView.LayoutManager tLayoutManager;

    FloatingActionButton floatingActionButton;
    BottomAppBar bottomAppBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_teacher_main);
        createitemlist();
        buildRecyclerView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        floatingActionButton = findViewById(R.id.fab);
        bottomAppBar = findViewById(R.id.bottomAppBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        BottomAppBar bar = (BottomAppBar) findViewById(R.id.bottomAppBar);

        bar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.action_search1) {
                    Toast.makeText(TeacherMain.this, "Search button is pressed",
                            Toast.LENGTH_LONG).show();
                    return true;
                }

                return true;
            }
        });

        BottomAppBar bar1 = (BottomAppBar) findViewById(R.id.bottomAppBar);
        bar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Initializing a bottom sheet
                BottomSheetDialogFragment bottomSheetDialogFragment = new bottomsheetfragment();

                //show it
                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());

                // Handle the navigation click by showing a BottomDrawer etc.
            }
        });



    }

    public void createitemlist() {
        //Adding items to instrument RecycleView
        mactList = new ArrayList<>();
        mactList.add(new teacherM_card_item(R.drawable.person,R.drawable.graph1, "Student1"));
    }

    public void buildRecyclerView() {
        tRecyclerView = (RecyclerView) findViewById(R.id.stu_teacherselect_recyclerview);//Had to be casted?
        tRecyclerView.setHasFixedSize(true);
        tLayoutManager = new LinearLayoutManager(this);
        tAdapter = new RecyclerViewAdapterTeMain_items(mactList);
        tRecyclerView.setLayoutManager(tLayoutManager);
        tRecyclerView.setAdapter(tAdapter);

        tAdapter.setOnItemClickListner(new RecyclerViewAdapterTeMain_items.OnItemClickListner() {
            @Override
            public void onItemclick(int position) {

            }
        });






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.teachermenu1, menu);
        bottomAppBar.replaceMenu(R.menu.teacherbottom);

        return true;

    }

    int item=R.id.action_search1;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.profile) {

            Intent intent = new Intent(this,edit_profile.class);
            this.startActivity(intent);
            return true;
        }

        if (id == R.id.sorting) {

            openSortDialog();
            return true;
        }




        return super.onOptionsItemSelected(item);
    }

    public void openSortDialog(){
        sortbydialog sortDialog=new sortbydialog();
        sortDialog.show(getSupportFragmentManager(),"Sort by dialog");

    }

}
