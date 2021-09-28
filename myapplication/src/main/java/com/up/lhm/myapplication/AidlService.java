package com.up.lhm.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;

import com.up.lhm.hmtools.system.Log;
import com.up.lhm.myapplication.aidl.Book;
import com.up.lhm.myapplication.aidl.IMyAidlInterface;
import com.up.lhm.myapplication.aidl.Person;

import java.util.List;


/**
 * @author barry
 * @date 2020/5/29
 * @function
 */

public class AidlService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public String getTime(String hint) {
            Log.d("AidlService", "服务端收到"+hint);
            return "12点"+hint;
        }

        @Override
        public void setTime(String time) {
            Log.d("AidlService", time);
            time="3";
        }

        @Override
        public void setTime2(List list) throws RemoteException {

        }

        @Override
        public Book getbook() throws RemoteException {
            Book book = new Book();

            book.age=12;
            book.name="爱到了";
            return book;
        }

        @Override
        public void setPerson(Person p) throws RemoteException {
            Log.d("AidlService","服务端收到Person"+ p.toString());
            p.setPlace("河南");
        }


    }
}
