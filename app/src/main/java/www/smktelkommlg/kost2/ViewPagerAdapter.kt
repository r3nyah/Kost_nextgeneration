package www.smktelkommlg.kost2

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.text.FieldPosition

class ViewPagerAdapter(private val mContext: Context,fm:FragmentManager):
    FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment{
        return if (position == 0 ){
            FirstFragment.newInstance()
        }else{
            SecondFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int):CharSequence?{
        return mContext.resources.getString(TAB_TITLES[position])
    }
    companion object {
        var image = intArrayOf(
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_baseline_favorite_24,
        )
        @StringRes
        //private val TAB_TITLES = intArrayOf(R.string.tab_text_1,R.string.tab_text_2)
        //private val TAB_TITLES = image
        private val TAB_TITLES = intArrayOf(R.string.home,R.string.heart)
    }
}