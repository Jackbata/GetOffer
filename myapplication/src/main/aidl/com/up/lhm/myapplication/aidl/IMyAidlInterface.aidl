// IMyAidlInterface.aidl
package com.up.lhm.myapplication.aidl;
import com.up.lhm.myapplication.aidl.Book;
import com.up.lhm.myapplication.aidl.Person;

// Declare any non-default types here with import statements

interface IMyAidlInterface {

                String getTime(String hint);

                void setTime( String time);
void setTime2(out List list);

                Book getbook();

                void setPerson(inout Person p);
}
