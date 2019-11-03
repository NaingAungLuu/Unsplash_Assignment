package com.androdev.unsplashapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.androdev.unsplashapp.R
import com.androdev.unsplashapp.adapters.StaggeredPhotoListAdapter
import com.androdev.unsplashapp.data.vos.PhotoVO
import com.androdev.unsplashapp.delegates.PhotoItemDelegate
import com.androdev.unsplashapp.mvp.presenters.PhotosListPresenter
import com.androdev.unsplashapp.mvp.views.PhotoListView
import com.androdev.unsplashapp.network.dataAgents.RetrofitDataAgent
import com.androdev.unsplashapp.utils.API_KEY
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class MainActivity : BaseActivity() , PhotoItemDelegate , PhotoListView{

    override fun navigateToDetail(url: String) {
       startActivity(DetailActivity.newIntent(applicationContext , url))
    }

    private lateinit var disposable : Disposable
    private lateinit var mAdapter : StaggeredPhotoListAdapter
    private lateinit var mPresenter : PhotosListPresenter

    override fun onTapPhoto(id: String) {
        mPresenter.onTapPhoto(id)
    }

    override fun showError(msg: String) {
        Toast.makeText(this ,msg , Toast.LENGTH_SHORT).show()
    }

    override fun showPhotos(photos: List<PhotoVO>) {
        mAdapter.setNewData(photos.toMutableList())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appBarLayout.outlineProvider = null
        appBarLayout.elevation = 0f
        etSearch.setPadding(24 , 16 , 16 , 16)
        //initialize Recycler view's adapter and the presenter
        mAdapter = StaggeredPhotoListAdapter(this)
        mPresenter = PhotosListPresenter()
        mPresenter.initPresenter(this)


        rvPhotos.adapter = mAdapter
        val layoutManager = StaggeredGridLayoutManager(2 ,LinearLayoutManager.VERTICAL)
        layoutManager.reverseLayout = false
        layoutManager.gapStrategy =StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        rvPhotos.layoutManager = layoutManager
        rvPhotos.itemAnimator = null

        mPresenter.onUIReady(this)

        disposable = Observable.create<String>{emitter ->

            etSearch.addTextChangedListener(object : TextWatcher{
                override fun afterTextChanged(p0: Editable?) {

                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    emitter.onNext(p0.toString())
                }

            })

        }.debounce(3 , TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .switchMap {
               searchPhoto(it)
            }
            .subscribeOn(Schedulers.computation())
            .subscribe(
                {

                },
                {

                }

            )


    }

    private val dataAgent = RetrofitDataAgent
    private fun searchPhoto(query : String): Observable<List<PhotoVO>>
    {
        var data : List<PhotoVO> = ArrayList()
         dataAgent.searchPhoto(API_KEY , query , {

            data = it

        },{

        })
        return Observable.just(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }



}
