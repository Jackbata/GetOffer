package com.up.lhm.client;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author barry
 * @date 2020/5/30
 * @function
 */

public class Person implements Parcelable {

    int time;
    String place;
    public Person(){

    }
    protected Person(Parcel in) {
        time = in.readInt();
        place = in.readString();
    }
    public  void readFromParcel(Parcel in) {
        time = in.readInt();
        place = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(time);
        dest.writeString(place);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Person{" +
                "time=" + time +
                ", place='" + place + '\'' +
                '}';
    }
}
