package studio.pyram3d.ui.pyramid

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import studio.pyram3d.R
import studio.pyram3d.data.Pyramid
import studio.pyram3d.databinding.FragmentPyramidBinding

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
        val spinner = binding.pyramidSides
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

        binding.buttonCalculate.setOnClickListener { view ->
            view.visibility = View.GONE

            val height: Double = binding.pyramidHeight.text.toString().toDouble()
            val base: Double = binding.pyramidBase.text.toString().toDouble()
            val sides: Int = binding.pyramidSides.selectedItem.toString().toInt()

            if (height > 0 || base > 0) {
                binding.pyramidHeight.isEnabled = false
                binding.pyramidBase.isEnabled = false
                binding.pyramidSides.isEnabled = false
            }
        }

        binding.buttonEdit.setOnClickListener { view ->
            view.visibility = View.GONE
            binding.pyramid.visibility = View.GONE

            binding.buttonCalculate.visibility = View.VISIBLE
            binding.pyramidHeight.isEnabled = true
            binding.pyramidBase.isEnabled = true
            binding.pyramidSides.isEnabled = true
        }

        return root
    }

    fun buttonClicked(view: View?) {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}