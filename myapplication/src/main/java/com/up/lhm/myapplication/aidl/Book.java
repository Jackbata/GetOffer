package com.up.lhm.myapplication.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author barry
 * @date 2020/5/29
 * @function
 */

public class Book implements Parcelable {
  public  int age;
    public  String name;
public Book(){

}

    protected Book(Parcel in) {
        age = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public String toString() {
        return "Book{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
