package at.vanishedwanderer.quotesc.ui.viewholders

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import at.vanishedwanderer.quotesc.R
import at.vanishedwanderer.quotesc.databinding.QuoteItemBinding

class QuoteViewHolder(val viewDataBinding: QuoteItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.quote_item
    }

}