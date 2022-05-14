package www.smktelkommlg.kost2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_card_adapter.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_first_fragment.*
import retrofit2.Call
import retrofit2.Callback

class DetailActivity : AppCompatActivity() {
    //private lateinit var rvHeroes: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //communicationViewModel = ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)
        NetworkConfig().getService()
            .getKosts()
            .enqueue(object : Callback<List<Response>> {
                //override fun onFailure(call: Call<List<www.smktelkommlg.kost2.Response>>, t: Throwable) {
                //Toast.makeText(this@FirstFragment, t.localizedMessage, Toast.LENGTH_SHORT).show()
                //}

                override fun onResponse(call: Call<List<Response>>, response: retrofit2.Response<List<Response>>) {
                    //rvHeroes = findViewById(R.id.rvUser2)
                    //rvHeroes.adapter = CardAdapter(response.body())
                    rvUser2.adapter = CardAdapter(response.body())
                }
                override fun onFailure(call: Call<List<Response>>, error: Throwable) {
                    Log.e("tag", "errornya ${error.message}")
                }

            })


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
        val moveHome = Intent(this,MainActivity::class.java)
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