package com.ossovita.fitnessui.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ossovita.fitnessui.Fragment.Details;
import com.ossovita.fitnessui.Fragment.FitnessPictures;

//VIEW PAGER İLE FRAGMENTLARI BAĞLAMAK İÇİN YAZDIĞIMIZ BİR CLASS
public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    //Seçime göre hangi fragment'i döndüreceğimizi yazdık
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment selectedFragment;

        switch (position){
            case 0:
                selectedFragment= FitnessPictures.newInstance();
                break;
            case  1:
                selectedFragment= Details.newInstance();
                break;
            default:
                return null;
        }


        return selectedFragment;
    }

    //ViewPagerın kaç tane fragment gösterebileceği
    @Override
    public int getCount() {
        return 2;
    }


    //Seçime göre hangi başlığı gösteceğimiz
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence selectedTitle;

        switch (position){
            case 0:
                selectedTitle = "Fitness Pictures";
                break;
            case 1:
                selectedTitle = "Details";
                break;
            default:
                return null;
        }
        return selectedTitle;
    }
}
