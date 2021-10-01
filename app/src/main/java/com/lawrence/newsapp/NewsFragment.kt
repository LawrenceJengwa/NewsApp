package com.lawrence.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lawrence.newsapp.data.util.Resource
import com.lawrence.newsapp.databinding.FragmentNewsBinding
import com.lawrence.newsapp.presantation.NewsViewModel
import com.lawrence.newsapp.view.MainActivity
import com.lawrence.newsapp.view.adapter.NewsAdapter



class NewsFragment : Fragment() {
    private lateinit var viewModel: NewsViewModel
    private lateinit var fragmentNewsBinding: FragmentNewsBinding
    private lateinit var adapter: NewsAdapter
    private var country = "us"
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentNewsBinding = FragmentNewsBinding.inflate(inflater, container, false)
        return fragmentNewsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        adapter = (activity as MainActivity).newsAdapter
        initRecyclerView()
        viewNewsList()
    }

    private fun viewNewsList() {
        viewModel.getNewsHeadLines(country, page )
        viewModel.newsHeadlines.observe(viewLifecycleOwner, {response->
            when(response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        adapter.differ.submitList(it.articles.toList())
                    }

                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message.let {
                        Toast.makeText(activity, "Error occurred : $it", Toast.LENGTH_LONG).show()
                    }

                }
                is Resource.Loading -> {
                    showProgressBar()

                }
            }
        })
    }

    private fun initRecyclerView() {
        //adapter = NewsAdapter()
        fragmentNewsBinding.rvNews.adapter = adapter
        fragmentNewsBinding.rvNews.layoutManager = LinearLayoutManager(activity)

    }

    private fun showProgressBar(){
        fragmentNewsBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        fragmentNewsBinding.progressBar.visibility = View.GONE
    }

}
