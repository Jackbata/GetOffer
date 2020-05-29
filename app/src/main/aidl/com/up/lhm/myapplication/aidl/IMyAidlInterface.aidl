// IMyAidlInterface.aidl
package com.up.lhm.myapplication.aidl;
import com.up.lhm.client.Book;
import com.up.lhm.client.Person;

// Declare any non-default types here with import statements

interface IMyAidlInterface {

                String getTime(String hint);

                void setTime( String time);
    void setTime2(out List list);
                Book getbook();
                //in、out、inout 表示：数据传输的方向(客户端和服务端)、修改数据后是否会同步到客户端
                //in：数据只能由客户端发送到服务端，服务端对数据对修改不会同步到客户端
                //out: 表示数据只能由服务端发送到客户端，当客户端发送消息时，服务端接收到的只是对象的初始值；服务端对数据进行修改后，将直接同步到客户端，无须设置返回值
                //inout：服务端可以接收到客户端发送的完整数据，同时对数据对修改也可以同步到客户端
                void setPerson( inout Person p);
}
