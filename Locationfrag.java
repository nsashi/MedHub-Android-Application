package medproject.practice.demo.medproject;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Saswati on 09-02-2017.
 */

public class Locationfrag extends Fragment {
    TextView tx1,tx2,tx3,tx4,tx5;
    public Locationfrag()
    {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView=inflater.inflate(R.layout.detailview,container,false);
        super.onCreateView(inflater,container,savedInstanceState);
        return rootView;
    }
    public void settingvalues(String location,String location_cor,String state,String district,String pincode)
    {
        tx1=(TextView) getView().findViewById(R.id.tx2);
        tx1.setText(location_cor);
        tx2=(TextView) getView().findViewById(R.id.tx3);
        tx2.setText(location);
        tx4=(TextView) getView().findViewById(R.id.tx5);
        tx4.setText(district);
        tx3=(TextView) getView().findViewById(R.id.tx4);
        tx3.setText(state);
        tx5=(TextView) getView().findViewById(R.id.tx6);
        tx5.setText(pincode);


    }
}
