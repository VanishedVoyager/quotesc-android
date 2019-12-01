package at.vanishedwanderer.quotesc.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import at.vanishedwanderer.quotesc.databinding.QuoteItemBinding
import at.vanishedwanderer.quotesc.domain.models.Quote
import at.vanishedwanderer.quotesc.ui.viewholders.QuoteViewHolder

class QuoteAdapter : RecyclerView.Adapter<QuoteViewHolder>() {

    var quotes: List<Quote> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val withDataBinding: QuoteItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            QuoteViewHolder.LAYOUT,
            parent,
            false
        )
        return QuoteViewHolder(withDataBinding)
    }

    override fun getItemCount() = quotes.size

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.quote = quotes[position]
        }
    }

}