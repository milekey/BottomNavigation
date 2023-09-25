package com.scaredeer.bottomnavigation.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.scaredeer.bottomnavigation.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    // This property (binding / _binding) is only valid between onCreateView and onDestroyView.
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)

        val notificationsViewModel = ViewModelProvider(this)[NotificationsViewModel::class.java]
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            binding.textNotifications.text = it
        }

        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}