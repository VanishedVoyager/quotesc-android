package at.vanishedwanderer.quotesc.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import at.vanishedwanderer.quotesc.R
import at.vanishedwanderer.quotesc.databinding.FragmentPersonsBinding

class PersonsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentPersonsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_persons,
            container,
            false
        )

        return binding.root
    }

}