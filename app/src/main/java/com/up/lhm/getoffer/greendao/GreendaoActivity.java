package com.up.lhm.getoffer.greendao;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.greendao.adapter.ShopListAdapter;
import com.up.lhm.getoffer.greendao.bean.Shop;
import com.up.lhm.getoffer.greendao.dao.ShopDao;
import com.up.lhm.hmtools.system.IntentUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Barry
 * @date 2019-06-05
 * @function
 */

public class GreendaoActivity extends AppCompatActivity {
    @BindView(R.id.btn_add)
    Button mBtnAdd;
    @BindView(R.id.btn_delete)
    Button mBtnDelete;
    @BindView(R.id.btn_edit)
    Button mBtnEdit;
    @BindView(R.id.btn_query)
    Button mBtnQuery;
    @BindView(R.id.ll_btn)
    LinearLayout mLlBtn;
    @BindView(R.id.listView)
    ListView mListView;
    @BindView(R.id.content_main)
    RelativeLayout mContentMain;

    private List<Shop> shops;
    private ShopListAdapter adapter;

    private int i;

    private ShopDao mShopDao;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, GreendaoActivity.class, finishSelf, args);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);
        ButterKnife.bind(this);
        initData();
    }
    private void initData() {
        shops = new ArrayList<>();
        mShopDao = new ShopDao();
        shops = mShopDao.queryShop();
        adapter = new ShopListAdapter(this, shops);
        mListView.setAdapter(adapter);
    }
    @OnClick({R.id.btn_add, R.id.btn_delete, R.id.btn_edit, R.id.btn_query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                Shop shop = new Shop();
                shop.setType(Shop.TYPE_CART);
                shop.setAddress("广东深圳");
                shop.setImage_url("https://img.alicdn.com/bao/uploaded/i2/TB1N4V2PXXXXXa.XFXXXXXXXXXX_!!0-item_pic.jpg_640x640q50.jpg");
                shop.setPrice("19.40");
                shop.setSell_num(15263);
                shop.setName("正宗梅菜扣肉 聪厨梅干菜扣肉 家宴常备方便菜虎皮红烧肉 2盒包邮" + i++);
                mShopDao.insertShop(shop);
                break;
            case R.id.btn_delete:
                if (!shops.isEmpty()) {
                    mShopDao.deleteShop(shops.get(0).getId());
                    initData();
                }
                break;
            case R.id.btn_edit:
                if (!shops.isEmpty()) {
                    Shop shop2 = shops.get(0);
                    shop2.setName("我是修改的名字");
                    mShopDao.updateShop(shop2);
                    initData();
                }
                break;
            case R.id.btn_query:
                mShopDao.queryAll();
                break;
                default:
                    break;
        }
        initData();
    }
}
