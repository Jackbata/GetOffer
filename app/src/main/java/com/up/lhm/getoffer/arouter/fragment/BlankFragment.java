package com.up.lhm.getoffer.arouter.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.up.lhm.getoffer.arouter.bean.TestObj;
import com.up.lhm.hmtools.system.ToastUtils;

/**
 * @author lianghaimiao
 * @date 2019/5/24
 * @function
 */

@Route(path = "/test/fragment")
public class BlankFragment extends Fragment {

    @Autowired
    String name;

    @Autowired(required = true)
    TestObj obj;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        Intent intent = getActivity().getIntent();
        String value = intent.getStringExtra("key2");
        ToastUtils.showShort("value:"+value);
        return textView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
