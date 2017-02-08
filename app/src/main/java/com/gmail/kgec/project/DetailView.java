package medproject.practice.demo.medproject;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetailView extends AppCompatActivity
{
    Contactdetailsfrag cf;
    Facilitiesfrag ff;
    Locationfrag lf;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "thirdscreen", Toast.LENGTH_SHORT).show();
        final MoreDetails md1;
        md1 =(MoreDetails)getIntent().getSerializableExtra("MyClass");
        t=(TextView) findViewById(R.id.hos_name);
        t.setText(md1.nm);
        if(savedInstanceState==null){
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.menubar,new MenuFragment());
            transaction.commit();
        }
        cf=new Contactdetailsfrag();
        cf.settingvalues(md1.telephone,md1.mobilenumber,md1.emergencynum,md1.ambulancenum,md1.bloodbankphn,md1.hospitalfax,md1.email,md1.website);
        ff=new Facilitiesfrag();
        ff.settingvalues(md1.specialities,md1.facilities,md1.numdoc,md1.totbed,md1.numprivateward);
        lf=new Locationfrag();
        lf.settingvalues(md1.address,md1.location_cordinates,md1.state,md1.district,md1.pincode);

    }
    }

