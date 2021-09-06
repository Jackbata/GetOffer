package com.up.lhm.getoffer.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;

import com.up.lhm.client.Book;
import com.up.lhm.client.Person;
import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.IntentUtil;
import com.up.lhm.hmtools.system.Log;
import com.up.lhm.myapplication.aidl.IMyAidlInterface;
import com.up.lhm.myapplication.aidl.IMyAidlInterface.Stub;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author barry
 * @date 2020/5/29
 * @function
 */

public class AIDLActivity extends BaseActivity {
    @BindView(R.id.send)
    Button mSend;
    @BindView(R.id.get)
    Button mGet;
    private IMyAidlInterface mIMyAidlInterface;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, AIDLActivity.class, finishSelf, args);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_aidl;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unbindService();
    }

    @Override
    public void initData() {
        Intent intent = new Intent("com.up.lhm.myapplication.AidlService");
        intent.setPackage("com.up.lhm.myapplication");
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mIMyAidlInterface = Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);
    }

    @OnClick({R.id.send, R.id.get,R.id.custom,R.id.sendcustom})
    public void onViewClicked(View view)  {
        switch (view.getId()) {
            case R.id.send:
                try {
                    String   time="客户端发送消息来了";
                    mIMyAidlInterface.setTime(time);
                    Log.d("AidlService", time);

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.get:
                try {
                    String time = mIMyAidlInterface.getTime("学习");
                    Log.d("AidlService","客户端"+  time);

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.custom:
                try {
                    Book getbook = mIMyAidlInterface.getbook();
                    Log.d("AidlService",getbook.toString());

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.sendcustom:
                try {
                    Person person = new Person();
                    person.setPlace("北京");
                    person.setTime(1258);
                    Log.d("AidlService","客户端发送perdon"+ person.toString());

                     mIMyAidlInterface.setPerson(person);
                    Log.d("AidlService","客户端收到perdon"+ person.toString());
                    person.setPlace("tia");
                    Log.d("AidlService","客户端收到perdon"+ person.toString());

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
