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
import kotlinx.android.synthetic.main.item_detail.view.*
import kotlinx.android.synthetic.main.item_user.view.*
import kotlinx.android.synthetic.main.item_user.view.desc
import kotlinx.android.synthetic.main.item_user.view.image
import kotlinx.android.synthetic.main.item_user.view.nama
import kotlinx.android.synthetic.main.item_user.view.price

//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.RequestOptions
class CardAdapter(val data: List<Response>?) : RecyclerView.Adapter<CardAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_detail, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
        //holder.itemView.setOnClickListener(View.OnClickListener {
            //Toast.makeText(holder.itemView.context,"Kamu Memilih" , Toast.LENGTH_SHORT).show()
            //activity.startActivity(Intent(activity, NVirementEmmeteur::class.java))
        //})
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: Response?) {
            with(itemView) {
                Glide.with(this)
                    .load(get?.imageUrl)
                    //.fitCenter()
                    .centerCrop()
                    .apply(RequestOptions().override(200, 200))
                    .into(itemView.image)
                itemView.nama.text = get?.name
                itemView.alamat.text = get?.address
                itemView.desc.text = get?.description

                itemView.genderbaru.text = get?.genderRestriction
                itemView.availabe.text = get?.availableBedrooms.toString()
                itemView.totalbedroom.text = get?.totalBedrooms.toString()
                itemView.pricetag.text = get?.price.toString()

            }
        }

    }

}