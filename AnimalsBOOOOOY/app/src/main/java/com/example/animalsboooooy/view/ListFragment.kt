package com.example.animalsboooooy.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.databinding.DataBindingUtil.inflate
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animalsboooooy.R
import com.example.animalsboooooy.databinding.FragmentListBinding.inflate
import com.example.animalsboooooy.model.Animal
import com.example.animalsboooooy.viewmodel.ListViewModel

class ListFragment : Fragment() {

    private var binding: AnimalListAdapter = null
    private val binding get() = binding

    private lateinit var viewModel: ListViewModel
    private val listAdapter = AnimalListAdapter(arrayListOf())

    private val animaListDataObserver = Observer<List<Animal>> {list ->
        list?.let{
            animalList.visibility = View.VISIBLE
            listAdapter.updateAnimalList(it)
        }
    }

    private val loadingLiveDataObserver = Observer<Boolean> {isLoading ->
        loadingView.visibility = if(isLoading) View.VISIBLE else View.GONE
        if(isLoading) {
            listError.visibility = View.GONE
            animalList.visibility = View.GONE
        }

    }

    private val errorLiveDataObserver = Observer<Boolean> {isError ->
        listError.visibility = if(isError) View.VISIBLE else View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListViewModel.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

//     override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflate.inflate(R.layout.fragment_list, container, false)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.animals.observe(viewLifecycleOwner, animaListDataObserver )
        viewModel.loading.observe(viewLifecycleOwner, loadingLiveDataObserver)
        viewModel.loadError.observe(viewLifecycleOwner, errorLiveDataObserver )
        viewModel.refresh()

        animalList.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = listAdapter
        }

        refreshLayout.setOnRefreshListener {
            animalList.visibility = View.GONE
            listError.visibility = View.GONE
            loadingView.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }
    }

}