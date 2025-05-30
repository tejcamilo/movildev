package com.example.movildev.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movildev.adapters.PostAdapter
import com.example.movildev.databinding.FragmentPostBinding
import com.example.movildev.viewmodels.PostViewModel


class PostFragment : Fragment() {

    /* --- View Binding --- */
    private var _binding: FragmentPostBinding? = null   // almacén interno
    private val binding get() = _binding!!              // acceso seguro

    private val viewModel by viewModels<PostViewModel>()
    private val adapter = PostAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerPosts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@PostFragment.adapter
        }

        viewModel.posts.observe(viewLifecycleOwner) { posts ->
            adapter.submitList(posts)
        }

        viewModel.fetchPosts()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null                // evita memory-leaks
    }
}
