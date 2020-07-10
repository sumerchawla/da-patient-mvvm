package com.doctoranywhere.patientmvvm.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.doctoranywhere.patientmvvm.R
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_main.view.*

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel<*>> : DaggerFragment() {

    var baseActivity: BaseActivity<*>? = null
    private var mRootView: View? = null
    private var viewDataBinding: T? = null
    private var mViewModel: V? = null
    private lateinit var toolbar: Toolbar

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract val bindingVariable: Int

    /**
     * @return layout resource id
     */
    @get:LayoutRes
    abstract val layoutId: Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): V

    override fun onAttach(context: Context) {
        performDependencyInjection()
        super.onAttach(context)
        if (context is BaseActivity<*>) {
            val activity = context as BaseActivity<*>?
            this.baseActivity = activity
            activity!!.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel();
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        mRootView = viewDataBinding!!.root
        return mRootView
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding!!.setVariable(bindingVariable, mViewModel)
        viewDataBinding!!.executePendingBindings()
        toolbar = baseActivity!!.findViewById(R.id.toolbar)
    }

    open fun getFragmentDataBinding(): T {
        return viewDataBinding!!
    }

    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }

    fun hideToolbar(){
        toolbar.setVisibility(View.GONE)
    }

    fun showToolbar(){
        toolbar.setVisibility(View.VISIBLE)
    }
    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}