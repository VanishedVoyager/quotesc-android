package at.vanishedwanderer.quotesc.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import at.vanishedwanderer.quotesc.R
import at.vanishedwanderer.quotesc.databinding.FragmentQuotesBinding
import at.vanishedwanderer.quotesc.domain.models.Quote
import at.vanishedwanderer.quotesc.ui.adapters.QuoteAdapter
import at.vanishedwanderer.quotesc.viewmodels.QuotescViewModel

class QuotesFragment : Fragment() {

    private val viewModel: QuotescViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated"
        }
        ViewModelProviders.of(this, QuotescViewModel.Factory(activity.application))
            .get(QuotescViewModel::class.java)
    }

    private var viewModelAdapter: QuoteAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.quotes.observe(viewLifecycleOwner, Observer<List<Quote>> { quotes ->
            quotes?.apply {

            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentQuotesBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_quotes,
            container,
            false
        )

        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = viewModel

        viewModelAdapter = QuoteAdapter()

        binding.root.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter
        }

        return binding.root
    }

}
