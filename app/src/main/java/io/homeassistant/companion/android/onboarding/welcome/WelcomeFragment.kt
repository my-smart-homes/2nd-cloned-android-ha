package io.homeassistant.companion.android.onboarding.welcome

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import io.homeassistant.companion.android.R
import io.homeassistant.companion.android.onboarding.discovery.DiscoveryFragment
import io.homeassistant.companion.android.onboarding.login.LoginFragment
import io.homeassistant.companion.android.onboarding.manual.ManualSetupFragment
import io.homeassistant.companion.android.util.compose.HomeAssistantAppTheme

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                HomeAssistantAppTheme {
                    WelcomeView(
                        onContinue = { welcomeNavigation() }
                    )
                }
            }
        }
    }

    private fun welcomeNavigation() {
        // goes to login
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.content, LoginFragment::class.java, null)
            .addToBackStack("Login")
            .commit()

    }
}
