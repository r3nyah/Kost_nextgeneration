package www.smktelkommlg.kost2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity() {
    private val fragmentList = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = IntroSliderAdapter(this)
        vpIntroSlider.adapter = adapter

        val addAll = fragmentList.addAll(
            listOf(
                IntroFragment1(), IntroFragment2(), IntroFragment3()
            )
        )
        adapter.setFragmentList(fragmentList)

        indicatorLayout.setIndicatorCount(adapter.itemCount)
        indicatorLayout.selectCurrentPosition(0)


        //view_pager.adapter = ViewPagerAdapter( this, supportFragmentManager)
        //tabs.setupWithViewPager(view_pager)

        NetworkConfig().getService()
            .getKosts()
            .enqueue(object : Callback<List<Response>> {
                //override fun onFailure(call: Call<List<www.smktelkommlg.kost2.Response>>, t: Throwable) {
                //Toast.makeText(this@FirstFragment, t.localizedMessage, Toast.LENGTH_SHORT).show()
                //}

                override fun onResponse(call: Call<List<Response>>, response: retrofit2.Response<List<Response>>) {
                    rvUser.adapter = Adapter(response.body())
                }
                override fun onFailure(call: Call<List<Response>>, error: Throwable) {
                    Log.e("tag", "errornya ${error.message}")
                }

            })


    }
    override fun onBackPressed(){
        finishAffinity()

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        val moveCardAdapter = Intent(this, DetailActivity::class.java)
        val moveHome = Intent(this, MainActivity::class.java)
        //val moveCloud = Intent(this,Cloud::class.java)
        when (selectedMode) {
            R.id.cloud -> {
                startActivity(moveCardAdapter)
                //mediaPlayer.stop()
            }
            R.id.home -> {
                startActivity(moveHome)
                //mediaPlayer.stop()
            }

        }
    }
}