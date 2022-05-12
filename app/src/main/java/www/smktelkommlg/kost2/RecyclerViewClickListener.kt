package www.smktelkommlg.kost2

import android.view.View

interface RecyclerViewClickListener {

    // method yang akan dipanggil di MainActivity
    fun onItemClicked(view: View, response: Response)

}