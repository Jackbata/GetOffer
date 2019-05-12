package com.up.lhm.getoffer.mvp.observer;


import com.up.lhm.hmtools.system.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lianghaimiao
 * @date 2019/4/20
 * @function
 */

public class ObserverMan implements IObserver, IObverListener {

    private List<IObserver> list = new ArrayList<IObserver>();

    @Override
    public void onCreade() {
        for (IObserver observer : list) {
            observer.onCreade();
        }
    }


    @Override
    public void onResume() {
        for (IObserver observer : list) {
            observer.onResume();
        }
    }

    @Override
    public void onDestory() {
        for (IObserver observer : list) {
            observer.onDestory();
        }
    }

    @Override
    public void addListener(IObserver obj) {
        boolean add = list.add(obj);
        if (add) {
            Log.d("mvptest", obj.toString() + "注册成功");
        }
    }

    @Override
    public void removeListener(IObserver obj) {
        for (int i = 0; i < list.size(); i++) {
            if (obj == list.get(i)) {
                IObserver remove = list.remove(i);
                if (remove != null) {
                    Log.d("mvptest", remove.toString() + "移除成功");
                }
                return;
            }
        }
    }
}