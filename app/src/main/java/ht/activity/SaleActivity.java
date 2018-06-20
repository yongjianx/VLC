package ht.activity;

import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.example.skyworthclub.visible_light_communication.R;

import ht.adapter.OnSaleViewPagerAdapter;
import ht.bean.ShopInfo;
import ht.fragment.OnSaleFragment;

import java.util.ArrayList;
import java.util.List;

public class SaleActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private OnSaleViewPagerAdapter mViewPagerAdapter;

    private Toolbar mToolbar;

    private List<Fragment> mFragmentList;
    private List<String> mTitleList;

    private List<ShopInfo> mFoodShopInfoList;
    private List<ShopInfo> mBeautyShopInfoList;
    private List<ShopInfo> mShopShopInfoList;
    private List<ShopInfo> mEntertainmentShopInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
        mToolbar = findViewById(R.id.toolbar_sale);
        mViewPager = findViewById(R.id.vp_sale);
        mTabLayout = findViewById(R.id.tab_sale);

        mToolbar.setTitle("促销信息");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getShopInfo();
        init();
        mViewPagerAdapter = new OnSaleViewPagerAdapter(getSupportFragmentManager(), mTitleList, mFragmentList);
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void init() {
        mFragmentList = new ArrayList<Fragment>();
        OnSaleFragment foodFragment = new OnSaleFragment();
        Bundle foodBundle = new Bundle();
        foodBundle.putParcelableArrayList("shop info", (ArrayList<? extends Parcelable>) mFoodShopInfoList);
        foodFragment.setArguments(foodBundle);

        OnSaleFragment shopFragment = new OnSaleFragment();
        Bundle shopBundle = new Bundle();
        shopBundle.putParcelableArrayList("shop info", (ArrayList<? extends Parcelable>) mShopShopInfoList);
        shopFragment.setArguments(shopBundle);

        OnSaleFragment beautyFragment = new OnSaleFragment();
        Bundle beautyBundle = new Bundle();
        beautyBundle.putParcelableArrayList("shop info", (ArrayList<? extends Parcelable>) mBeautyShopInfoList);
        beautyFragment.setArguments(beautyBundle);

        OnSaleFragment entertainmentFragment = new OnSaleFragment();
        Bundle entertainmentBundle = new Bundle();
        entertainmentBundle.putParcelableArrayList("shop info", (ArrayList<? extends Parcelable>) mEntertainmentShopInfoList);
        entertainmentFragment.setArguments(entertainmentBundle);

        mFragmentList.add(foodFragment);
        mFragmentList.add(shopFragment);
        mFragmentList.add(beautyFragment);
        mFragmentList.add(entertainmentFragment);

        mTitleList = new ArrayList<String>();
        mTitleList.add("美食");
        mTitleList.add("购物");
        mTitleList.add("丽人");
        mTitleList.add("娱乐");

    }

    private void getShopInfo() {
        mFoodShopInfoList = new ArrayList<ShopInfo>();
        ShopInfo shopInfo1 = new ShopInfo("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=70e3b29c2b3fb80e0cd166d10eea4813/b8014a90f603738dd87db28fb91bb051f819ec6c.jpg", "必胜客", "美食", "6折", "4层");
        ShopInfo shopInfo2 = new ShopInfo("https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=3225978deb24b899de3c7e3e563d7aa8/0823dd54564e9258cb143b639e82d158ccbf4e1e.jpg", "味千拉面", "美食", "7折", "4层");
        ShopInfo shopInfo3 = new ShopInfo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511965218933&di=8f966c82eddcd5f08cb91dfea0101503&imgtype=0&src=http%3A%2F%2Fimages4.c-ctrip.com%2Ftarget%2F2A0q080000002vvwnBECB_720_480_s.jpg", "仙庙烧鸡", "美食", "6折", "4层");
        ShopInfo shopInfo4 = new ShopInfo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511965278769&di=198c2265e5a4ceb86c3304f2b0dbadc0&imgtype=0&src=http%3A%2F%2Fm.gafei.com%2Fuploads%2Fallimg%2F150805%2F1526311201-0.jpg", "星巴克", "饮料甜品", "8折", "1层");
        ShopInfo shopInfo5 = new ShopInfo("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=108401662,495393994&fm=27&gp=0.jpg", "哈根达斯", "甜品", "8折", "1层");
        mFoodShopInfoList.add(shopInfo1);
        mFoodShopInfoList.add(shopInfo2);
        mFoodShopInfoList.add(shopInfo3);
        mFoodShopInfoList.add(shopInfo4);
        mFoodShopInfoList.add(shopInfo5);

        mShopShopInfoList = new ArrayList<ShopInfo>();
        ShopInfo shopInfo6 = new ShopInfo("http://img5.imgtn.bdimg.com/it/u=1041684705,37175222&fm=27&gp=0.jpg", "H.M", "服饰", "5折", "2层");
        ShopInfo shopInfo7 = new ShopInfo("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=908900097,1207226793&fm=27&gp=0.jpg", "阿迪达斯", "服饰", "5折", "2层");
        ShopInfo shopInfo8 = new ShopInfo("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1002370771,1024722406&fm=27&gp=0.jpg", "美特斯邦威", "服饰", "5折", "2层");
        ShopInfo shopInfo9 = new ShopInfo("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1785749170,928843480&fm=27&gp=0.jpg", "LV", "服饰", "5折", "2层");
        mShopShopInfoList.add(shopInfo6);
        mShopShopInfoList.add(shopInfo7);
        mShopShopInfoList.add(shopInfo8);
        mShopShopInfoList.add(shopInfo9);

        mBeautyShopInfoList = new ArrayList<ShopInfo>();
        ShopInfo shopInfo10 = new ShopInfo("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=569210839,2747081036&fm=27&gp=0.jpg", "悦诗风吟", "护肤", "8折", "3层");
        ShopInfo shopInfo11 = new ShopInfo("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3417469812,3266857165&fm=27&gp=0.jpg", "迪奥", "妆容", "6折", "3层");
        ShopInfo shopInfo12 = new ShopInfo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511965946316&di=fb56f73b2775db31597609a5e10f88e1&imgtype=0&src=http%3A%2F%2Fpic17.nipic.com%2F20111114%2F8806161_122851242108_2.jpg", "兰蔻", "妆容", "6折", "3层");
        ShopInfo shopInfo13 = new ShopInfo("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1844477444,3040145371&fm=27&gp=0.jpg", "屈臣氏", "护理", "8折", "3层");
        mBeautyShopInfoList.add(shopInfo10);
        mBeautyShopInfoList.add(shopInfo11);
        mBeautyShopInfoList.add(shopInfo12);
        mBeautyShopInfoList.add(shopInfo13);

        mEntertainmentShopInfoList = new ArrayList<ShopInfo>();
        ShopInfo shopInfo14 = new ShopInfo("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3843968175,2510008774&fm=27&gp=0.jpg", "爱尚ktv", "娱乐", "8折", "5层");
        ShopInfo shopInfo15 = new ShopInfo("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAH0AfQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD3+iiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAMvV9VOlpEwg80OSPvbcfpWX/AMJef+fL/wAi/wD1q1dbsDqGnmNMeYp3Jn19K4V0aNirqVYHBBGCK87FVatOfuvQ6aNOE1rudL/wl5/58v8AyL/9aj/hLz/z5f8AkX/61cxRXL9brdzf6vDsdP8A8Jef+fL/AMi//Wo/4S8/8+X/AJF/+tXMUUfW63cPq8Ox0/8Awl5/58v/ACL/APWo/wCEvP8Az5f+Rf8A61cxWhpmkTalJlfkhH3pCP0HvVQxNebtFkyo04q7NhPFckrhI9PLsegWTJ/lWta3d/cLuksVhXtvm5/LbWLqmuaB4LtMzOPPYfLEhDSyf4D8hXmOt/FLXNRdksGXT7foAgDOR7sR/LFehDnj/ElqVQwNTE60o2Xdnt15qFpYQ+beXMNun96WQKPzNYl14/8AC1ocSaxA/b9yGk/9BBrwWzstV8SamIYFnvbuTqzMWIHqzHoPrXqegfCOwt0EmtzG7l/55RMUjH48Mf0rVTctkdFbAYfDL99Uu+yNR/it4XViBNcuB3WA4/WrNl8S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4H+Kkd3Y3kdxYWV+VE0D+YsluTg4IPPyE+vNdd4F+Bdz4l0WW91ye+0eZZjHHbyWuGZQAdxDYIySR07VmeP/AIN6r4YubJdDh1HW4Z0cyNBZs5iYEcHZnAIIxn0NAH1VFKk8SyRsrIwDKynIIPcGvNPi38PrXxha2t0mpWun6hbBlSS5bCSoedpPbnocHqeOeNn4U3OpTeALC31axu7O8sh9laO6haNmVfusAwBI2lRn1B9K8++OXw31PWdQg8R6JbS3knlCG6toV3P8udrqOp4OCAOwPrgA81l8LfELwKjX1rHqFvaqPNN1p8xeJkxncxQkbcD+LjFei/B/4tatreuxeHPEEouXmVvs11tAfcqlirkcHgHBxnPrmuUsfiD8QtN8LHwsNCkYLCbRJJbKXzkQgqFx0JAOBkdh1re+C3wy1iz8Rp4j1qzmsY7VWFtDOhWSR2BUkqeQACevUkYoA+iKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKTIpa4K9tdXk+Idvej7QtjFC52GTCso27ioUtnJIOCBnFTKVjWlTVRtN2smzvcijNeZabL4hks9RWMXzST3Hmx3ExZAi7wBtQxnAIJbgHgHPoZrv+2305Nt1qU0gum4W3lg2jLYJwAWQ8ZA5A6c4qefTY1eFtLlckejZorC8NLOuhwi4+0eflvM85nyWz2387fT2x3zRVpnPJWbRvUUUUyQooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKy7jS7S7LvMkhLZziZ1BBABGAenA4ooo6iYf2VaGQsRNknk+e/OBj19hTI9FsoiwT7QAwII+0yd+D/F7UUVQi5b20VujLGG2li3zOW5PXqaKKKQj/2Q==", "金逸电影院", "影视娱乐", "5折", "5层");
        mEntertainmentShopInfoList.add(shopInfo14);
        mEntertainmentShopInfoList.add(shopInfo15);

    }
}

