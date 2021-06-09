package studio.pyram3d.ui.pyramid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import studio.pyram3d.R
import studio.pyram3d.data.Pyramid
import studio.pyram3d.databinding.FragmentPyramidBinding
import java.lang.Exception
import kotlin.math.nextTowards

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
            try {
                val height: Double = binding.pyramidHeight.text.toString().toDouble()
                val base: Double = binding.pyramidBase.text.toString().toDouble()
                val sides: Int = binding.pyramidSides.selectedItemPosition + 3

                if (height > 0 || base > 0) {
                    view.visibility = View.GONE
                    binding.pyramidHeight.isEnabled = false
                    binding.pyramidBase.isEnabled = false
                    binding.pyramidSides.isEnabled = false

                    binding.buttonEdit.visibility = View.VISIBLE

                    binding.pyramid.visibility = View.VISIBLE

                    val pyramid = Pyramid(height, base, sides)

                    binding.height.text = pyramid.height.toString()
                    binding.base.text = pyramid.base.toString()
                    binding.sides.text = pyramid.laterals.size.toString()
                    binding.area.text = pyramid.area.toString()
                    binding.apothem.text = String.format("%.4f", pyramid.laterals.first().apothem)
                    binding.volume.text = pyramid.volume.toString()
                }
                else Toast.makeText(view.context, R.string.fragment_pyramid_calc_zero, Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}