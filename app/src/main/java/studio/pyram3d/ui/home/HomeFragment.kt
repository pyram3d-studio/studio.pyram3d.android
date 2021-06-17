package studio.pyram3d.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import studio.pyram3d.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val cardCuriosity: TextView = binding.cardCuriosity
        homeViewModel.cardSuggestion.observe(viewLifecycleOwner, {
            cardCuriosity.text = getString(it)
        })

        binding.buttonContinue.setOnClickListener { _ ->
            val uri: Uri =
                Uri.parse("https://pyram3d.studio")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}