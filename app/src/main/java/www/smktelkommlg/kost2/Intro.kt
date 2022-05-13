package www.smktelkommlg.kost2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.VideoView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Intro : AppCompatActivity() {
    private lateinit var videoView : VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val mButton1 = findViewById<Button>(R.id.button)
        val mButton2 = findViewById<Button>(R.id.button2)

        val mButton3 = findViewById<Button>(R.id.button3)
        val mButton4 = findViewById<Button>(R.id.button4)

        val mButton5 = findViewById<Button>(R.id.button5)
        val mButton6 = findViewById<Button>(R.id.button6)

        videoView=findViewById(R.id.videoView)
        val Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.opening)
        videoView.setVideoURI(Uri)
        videoView.start()
        val moveIntent = Intent(this, MainActivity::class.java)
        mButton4.setOnClickListener{
            startActivity(moveIntent)
        }


        lifecycleScope.launch(Dispatchers.Default){
            try{
                for (i in 0..50){
                    delay(1000)
                    val percentage = i*10

                    withContext(Dispatchers.Main){
                        if(percentage == 100){
                            //startActivity(moveIntent)
                            videoView.stopPlayback()
                            videoView.visibility = View.INVISIBLE

                            mButton1.visibility = View.VISIBLE
                            mButton2.visibility = View.VISIBLE
                            mButton3.visibility = View.VISIBLE
                            mButton4.visibility = View.VISIBLE
                            mButton5.visibility = View.VISIBLE
                            mButton6.visibility = View.VISIBLE
                        }
                    }
                }
            }catch (e : Exception){
                e.printStackTrace()
            }

        }

    }


}


