package www.smktelkommlg.kost2


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText

import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_first_fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment() {
    //private var communicationViewModel : CommunicationViewModel?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //communicationViewModel = ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)
        NetworkConfig().getService()
            .getKosts()
            .enqueue(object : Callback<List<www.smktelkommlg.kost2.Response>> {
                //override fun onFailure(call: Call<List<www.smktelkommlg.kost2.Response>>, t: Throwable) {
                //Toast.makeText(this@FirstFragment, t.localizedMessage, Toast.LENGTH_SHORT).show()
                //}

                override fun onResponse(
                    call: Call<List<www.smktelkommlg.kost2.Response>>,
                    response: Response<List<www.smktelkommlg.kost2.Response>>
                ) {
                    rvUser.adapter = Adapter(response.body())
                }
                override fun onFailure(call: Call<List<www.smktelkommlg.kost2.Response>>, error: Throwable) {
                    Log.e("tag", "errornya ${error.message}")
                }

            })
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_first_fragment,container,false)
    }

    companion object{
        fun newInstance(): FirstFragment{
            return FirstFragment()
        }
    }
}