package com.oo.galactictroopers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.oo.galactictroopers.databinding.FragmentMenuPageBinding
import com.oo.galactictroopers.databinding.FragmentStartGameBinding
import com.oo.galactictroopers.databinding.FragmentStoryTellBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StoryTellFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StoryTellFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentStoryTellBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        val textView: TextView = requireView().findViewById(R.id.typewriterTextView)
        val message = "Hello Commander Spark, I'm sure your memories must be quite hazy. We need you to feel better as soon as possible, we would not be able to overcome this new trouble we are facing. We need your expertise to guide the fleet safely to the end of our solar system"
        textView.typeWrite(viewLifecycleOwner, message, 33L)
        val textView2: TextView = requireView().findViewById(R.id.typewriterTextView2)
        val message2 = "Ran out of ideas, I've been doing this project non-stop since I started it at 8am this morning and it's 4pm, I need sleep. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
        textView2.typeWrite(viewLifecycleOwner, message2, 33L)
        binding.storyBackButton.setOnClickListener{
            navController.navigate(R.id.action_storyTellFragment_to_startGameFragment)
        }
        binding.continueButton.setOnClickListener{
            navController.navigate(R.id.action_storyTellFragment_to_gamePlayFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStoryTellBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun TextView.typeWrite(lifecycleOwner: LifecycleOwner, text: String, intervalMs: Long) {
        this@typeWrite.text = ""
        lifecycleOwner.lifecycleScope.launch {
            repeat(text.length) {
                delay(intervalMs)
                this@typeWrite.text = text.take(it + 1)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StoryTellFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StoryTellFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}