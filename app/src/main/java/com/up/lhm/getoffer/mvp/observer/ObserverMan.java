package com.up.lhm.getoffer.mvp.observer;


import com.up.lhm.hmtools.system.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lianghaimiao
 * @date 2019/4/20
 * @function
 */

public class ObserverMan implements IObserver, IObverListener {

    private List<IObserver> list = new ArrayList<IObserver>();
    private List<IObserver> ulist = new ArrayList<IObserver>();

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

        list.clear();
        list.addAll(ulist);
    }

    @Override
    public void addListener(IObserver obj) {
        synchronized (list){
            boolean add = list.add(obj);
            ulist.add(obj);
            if (add) {
                Log.d("mvptest", obj.toString() + "注册成功");
            }
        }

    }

    @Override
    public void removeListener(IObserver obj) {
        Log.d("mvptest","removeListener--"+obj.getClass().getSimpleName() );
        Iterator<IObserver> it = ulist.iterator();
        while(it.hasNext()){
            IObserver x = it.next();
            if(x.equals(obj)){
                it.remove();
            }
        }
    }
}