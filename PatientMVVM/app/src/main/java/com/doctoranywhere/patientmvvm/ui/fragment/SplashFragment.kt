package com.doctoranywhere.patientmvvm.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.doctoranywhere.patientmvvm.BR
import com.doctoranywhere.patientmvvm.R
import com.doctoranywhere.patientmvvm.databinding.FragmentSplashBinding
import com.doctoranywhere.patientmvvm.di.factory.DaggerViewModelFactory
import com.doctoranywhere.patientmvvm.ui.base.BaseFragment
import com.doctoranywhere.patientmvvm.ui.viewmodel.SplashViewModel
import com.doctoranywhere.patientmvvm.utils.Constants
import javax.inject.Inject

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>() {

    @Inject lateinit var providerFactory: DaggerViewModelFactory

    private val mViewModel: SplashViewModel by lazy {
            ViewModelProvider(this, providerFactory)[SplashViewModel::class.java]
    }


    override val bindingVariable: Int
        get() = BR.splashViewModel


    override val layoutId: Int
        get() = R.layout.fragment_splash

    override fun getViewModel(): SplashViewModel {
        return mViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
    }

    private fun initializeView() {
        hideToolbar()
        Handler().postDelayed({
            Navigation.findNavController(view!!)
                .navigate(R.id.action_FirstFragment_to_SecondFragment)
        }, Constants.SPLASH_DISPLAY_TIME.toLong())    }
}
