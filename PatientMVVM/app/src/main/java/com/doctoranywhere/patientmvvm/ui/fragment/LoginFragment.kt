package com.doctoranywhere.patientmvvm.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.doctoranywhere.patientmvvm.BR
import com.doctoranywhere.patientmvvm.R
import com.doctoranywhere.patientmvvm.databinding.FragmentLoginBinding
import com.doctoranywhere.patientmvvm.di.factory.DaggerViewModelFactory
import com.doctoranywhere.patientmvvm.ui.base.BaseFragment
import com.doctoranywhere.patientmvvm.ui.viewmodel.LoginViewModel
import javax.inject.Inject

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    @Inject lateinit var providerFactory: DaggerViewModelFactory

    private val mViewModel: LoginViewModel by lazy {
            ViewModelProvider(this, providerFactory)[LoginViewModel::class.java]
    }

    override val bindingVariable: Int
        get() = BR.loginViewModel

    override val layoutId: Int
        get() = R.layout.fragment_login

    override fun getViewModel(): LoginViewModel {
        return mViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showToolbar()
    }
}
