package www.smktelkommlg.kost2

import android.view.View

interface RecyclerViewClickListener {

    class OnClickListener(val clickListener: (response: Response) -> Unit) {
        fun onClick(response: Response) = clickListener(response)
    }
}