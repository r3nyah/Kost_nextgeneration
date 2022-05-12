package www.smktelkommlg.kost2


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_user.view.*
//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.RequestOptions


class Adapter(val data: List<Response>?) : RecyclerView.Adapter<Adapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: Response?) {
            with(itemView) {
                itemView.nama.text = get?.name
                itemView.desc.text = get?.description
                Glide.with(this)
                    .load(get?.imageUrl)
                    .fitCenter()
                    .apply(RequestOptions().override(100, 100))
                    .into(itemView.image)
            }
        }

    }

}