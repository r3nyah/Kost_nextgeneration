package www.smktelkommlg.kost2


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
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
        holder.itemView.setOnClickListener(View.OnClickListener {
            Toast.makeText(holder.itemView.context,"Kamu Memilih" , Toast.LENGTH_SHORT).show()
            //activity.startActivity(Intent(activity, NVirementEmmeteur::class.java))
        })
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
                itemView.price.text = get?.price.toString()
                
            }
        }

    }
    inner class Adapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.image)
        var namae: Button = itemView.findViewById(R.id.nama)

    }
}