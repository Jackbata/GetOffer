package com.libs.jetpacks.databinding.viewmodel;

import android.util.Log;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;
import com.libs.jetpacks.databinding.bean.Books;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/9/30 3:08 PM
 */
public class DataViewmodel {
String TAG=this.getClass().getSimpleName();
  public ObservableField<Books> getBooksObservableField() {
    return booksObservableField;
  }

  private final ObservableField<Books> booksObservableField;
  Books books = new Books();

  public DataViewmodel(){
    booksObservableField = new ObservableField<>();
    books.name="DataViewmodel hhhhhh";
    books.price=1000;
    booksObservableField.set(books);
  }

  public String getName() {
    return booksObservableField.get().name;
  }

  public void setName(String name) {
    if (name!=books.name){
      booksObservableField.get().name=name;
      booksObservableField.notifyChange();
    }
  }

  public void updata(String  string) {
      books.name=string;
  }

//  @Bindable
//  public String getName() {
//    Log.d(TAG, "getName: "+books.name);
//    return books.name;
//  }
//
//  public void setName(String name) {
//    if (name!=null&&name!=books.name){
//      Log.d(TAG, "setName: "+name);
//      books.name=name;
//      notifyPropertyChanged(BR.name);
//    }
//  }

}
