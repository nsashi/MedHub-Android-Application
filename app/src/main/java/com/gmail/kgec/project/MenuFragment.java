package medproject.practice.demo.medproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MenuFragment extends Fragment {
    Button button1, button2, button3;
    Fragment frag;
    FragmentTransaction ft;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.menu_layout, container, false);

        frag=new Locationfrag();
        ft=getFragmentManager().beginTransaction().add(R.id.container1,frag);
        ft.commit();
        button1 = (Button) view.findViewById(R.id.button1);
        button2 = (Button) view.findViewById(R.id.button2);
        button3 = (Button) view.findViewById(R.id.button3);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag=new Locationfrag();
                ft=getFragmentManager().beginTransaction().replace(R.id.container1,frag);
                ft.commit();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag=new Contactdetailsfrag();
                ft=getFragmentManager().beginTransaction().replace(R.id.container1,frag);
                ft.commit();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag=new Facilitiesfrag();
                ft=getFragmentManager().beginTransaction().replace(R.id.container1,frag);
                ft.commit();
            }
        });

        return view;
    }



}
