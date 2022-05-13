package www.smktelkommlg.kost2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class CardAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_adapter)
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
        val moveCardAdapter = Intent(this, CardAdapter::class.java)
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