package com.up.lhm.getoffer.mvp.base;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.up.lhm.getoffer.mvp.observer.IObserver;
import com.up.lhm.getoffer.mvp.observer.IObverListener;
import com.up.lhm.getoffer.mvp.observer.ObserverMan;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * @author lianghaimiao
 * @date 2019/4/20
 * @function
 */

public abstract class BaseFragment extends Fragment implements IObverListener {
    private ObserverMan mObserverMan;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /**
         *注册
         */
        mObserverMan = new ObserverMan();
        initData();
        mObserverMan.onCreade();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public abstract void initData();

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
    }

    @Override
    public void addListener(IObserver listener) {
        mObserverMan.addListener(listener);
    }

    @Override
    public void removeListener(IObserver listener) {
        mObserverMan.removeListener(listener);
    }
}
