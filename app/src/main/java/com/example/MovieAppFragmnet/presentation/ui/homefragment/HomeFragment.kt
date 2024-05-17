package com.example.MovieAppFragmnet.presentation.ui.homefragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.MovieAppFragment.R
import com.example.MovieAppFragment.databinding.FragmentHomeBinding
import com.example.MovieAppFragmnet.data.MoviesListData
import com.example.MovieAppFragmnet.presentation.adapter.homefragmentadapter.movieslistadapter.MoviesListAdapter
import com.example.MovieAppFragmnet.presentation.ui.mainfragment.MainFragmentDirections
import com.example.MovieAppFragmnet.presentation.viewmodel.NowPlayingViewModel
import com.example.MovieAppFragmnet.presentation.viewmodel.PopularViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private val adapter = MoviesListAdapter()
    private val nowPlayingViewModel by viewModel<NowPlayingViewModel>()
    private val popularViewModel by viewModel<PopularViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)


        setupData()
        setupListeners()
        setupObservers()
    }

    private fun setupData() {
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            nowPlayingViewModel.getNowPlayingMovies()
            popularViewModel.getPopularMovies()
        }
    }

    private fun setupListeners() {


        adapter.setOnItemClickListener {
            val navHostFragment =
                requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
            val navController = navHostFragment.findNavController()
            navController.navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(it))
        }
    }

    private fun setupObservers() {

        val moviesList = mutableListOf<MoviesListData>()

        moviesList.add(MoviesListData("Now Playing", listOf()))
        moviesList.add(MoviesListData("Popular", listOf()))

        // Now Playing observers

        nowPlayingViewModel.successFlow.onEach {
            moviesList.elementAt(0).data = it
        }.launchIn(lifecycleScope)

        nowPlayingViewModel.messageFlow.onEach {
            Toast.makeText(requireContext(), "Message1: $it", Toast.LENGTH_SHORT).show()
        }.launchIn(lifecycleScope)

        nowPlayingViewModel.errorFlow.onEach {
            Toast.makeText(requireContext(), "Error1: $it", Toast.LENGTH_SHORT).show()
        }.launchIn(lifecycleScope)


        // Popular observers

        popularViewModel.successFlow.onEach {
            moviesList.elementAt(1).data = it
            adapter.submitList(moviesList)
        }.launchIn(lifecycleScope)

        popularViewModel.messageFlow.onEach {
            Log.d("GGGG", "Message2: $it")
            Toast.makeText(requireContext(), "Message2: $it", Toast.LENGTH_SHORT).show()
        }.launchIn(lifecycleScope)

        popularViewModel.errorFlow.onEach {
            Toast.makeText(requireContext(), "Error2: $it", Toast.LENGTH_SHORT).show()
        }.launchIn(lifecycleScope)
    }
}
