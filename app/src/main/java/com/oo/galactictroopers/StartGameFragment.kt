package com.oo.galactictroopers

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.oo.galactictroopers.databinding.FragmentMenuPageBinding
import com.oo.galactictroopers.databinding.FragmentStartGameBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StartGameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartGameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentStartGameBinding
    private lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        val imageView: ImageView = requireView().findViewById(R.id.rotatingPlanetsView)
        Glide.with(this).load(R.drawable.rotating_planets).into(imageView)
        binding.playButton.setOnClickListener{
            navController.navigate(R.id.action_startGameFragment_to_storyTellFragment)
        }
        binding.exitButton.setOnClickListener{
            navController.navigate(R.id.action_startGameFragment_to_confirmationFragment)
        }
        binding.optionsButton.setOnClickListener{
            navController.navigate(R.id.action_startGameFragment_to_optionsFragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val themeSongMP = MediaPlayer.create(requireActivity(), R.raw.galactic_troopers_theme_song)
        binding = FragmentStartGameBinding.inflate(inflater, container, false)
        themeSongMP.setLooping(true)
        binding.musicOffButton.setOnClickListener{
            themeSongMP.pause()
        }
        binding.musicOnButton.setOnClickListener{
            themeSongMP.start()
        }

        return binding.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondBlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StartGameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}