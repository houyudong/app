package niaodoctor.ciyun.com.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button one;
Button two;
    private BlankFragment fragment1;
    private BlankFragment2 fragment2;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       one = findViewById(R.id.one);
       two = findViewById(R.id.two);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        fragment1 = new BlankFragment();
        fragment2 = new BlankFragment2();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_fragment_container,fragment1).show(fragment1);
        fragmentTransaction.add(R.id.main_fragment_container,fragment2).hide(fragment2);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.one:
                fragmentTransaction.show(fragment1).hide(fragment2).commit();
                break;
            case R.id.two:  fragmentTransaction.show(fragment2).hide(fragment1).commit();
                break;
        }
    }
}
