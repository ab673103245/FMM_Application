package qianfeng.fmm_application;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class AboveFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.abovefragment, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.fragment_viewpager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        List<Fragment> list = new ArrayList<>();
        List<String> titiles = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            list.add(new InnerFragment());
            titiles.add("标题:"+i);
        }

        viewPager.setAdapter(new InnerAdapter(getActivity().getSupportFragmentManager(),list,titiles));

        tabLayout.setupWithViewPager(viewPager); // 与viewPager关联起来
        return view;
    }
}
