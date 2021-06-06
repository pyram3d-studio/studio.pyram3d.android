package studio.pyram3d

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import studio.pyram3d.databinding.ActivityPyramidBinding

class PyramidActivity : AppCompatActivity() {


    // private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityPyramidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPyramidBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}