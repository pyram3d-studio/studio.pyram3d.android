package app.pyram3d.ui.pyramid

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import app.pyram3d.R
import app.pyram3d.databinding.FragmentPyramidBinding

class PyramidFragment : Fragment() {

    private lateinit var viewModel: PyramidViewModel
    private var _binding: FragmentPyramidBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(PyramidViewModel::class.java)
        _binding = FragmentPyramidBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val spinner = binding.pyramidSidesSpinner
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.fragment_pyramid_sides_spinners,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}