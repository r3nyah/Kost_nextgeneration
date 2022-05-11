package www.smktelkommlg.kost2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CommunicationViewModel : ViewModel() {
    private val mName = MutableLiveData<String>()
    val name: LiveData<String>
        get() = mName

    fun setName(name:String) {
        mName.value = name


    }
    private val mEmail = MutableLiveData<String>()
    val email: LiveData<String>
        get() = mEmail

    fun setEmail(email:String) {
        mEmail.value = email


    }
    private val mKelas = MutableLiveData<String>()
    val kelas: LiveData<String>
        get() = mKelas

    fun setKelas(kelas:String) {
        mKelas.value = kelas


    }
    private val mHobi = MutableLiveData<String>()
    val hobi: LiveData<String>
        get() = mHobi

    fun setHobi(hobi:String) {
        mHobi.value = hobi


    }

}
