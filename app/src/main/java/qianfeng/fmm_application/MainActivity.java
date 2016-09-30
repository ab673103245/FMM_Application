package qianfeng.fmm_application;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = ((ViewPager) findViewById(R.id.viewPager));
        rg = ((RadioGroup) findViewById(R.id.rg));

        List<Fragment> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new AboveFragment());
        }

        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),list));

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rb1:
                        viewPager.setCurrentItem(0);
                        break;

                    case R.id.rb2:
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.rb3:
                        viewPager.setCurrentItem(2);
                        break;

                    case R.id.rb4:
                        viewPager.setCurrentItem(3);
                        break;
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton) rg.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    public void onclickimageView(View view) {
        Toast.makeText(this,"123",Toast.LENGTH_SHORT).show();
    }
}
