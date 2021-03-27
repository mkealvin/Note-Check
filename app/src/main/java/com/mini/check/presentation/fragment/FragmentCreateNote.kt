package com.mini.check.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mini.check.R
import com.mini.check.presentation.viewmodel.NoteViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_create_note.*
import org.koin.android.architecture.ext.viewModel


class FragmentCreateNote : Fragment() {

    private val noteViewModel by viewModel<NoteViewModel>()

    private val compositeDisposable = CompositeDisposable() // berfungsi untuk menangani API http request

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }// berfungsi untuk inisiasi view dengan nama

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSaveButton()
    }// membuat method ketika method di jalankan akan memamnggil initSvebutton

    private fun initSaveButton() {
        create_note_button.setOnClickListener { view ->
            val disposable = Observable.just(true)
                .observeOn(Schedulers.io())// menjalankan default threading di RxJava
                .map { note_text_field.text.toString() }
                .doOnNext { noteViewModel.saveNote(it) }
                .observeOn(AndroidSchedulers.mainThread())//observeOn menginstruksikan sumber Observable thread mana
                                                            // yang akan memancarkan item - thread ini akan mendorong emisi sampai ke Observer.
                .subscribe { note_text_field.setText("") }// memerintahkan semua operator akan di eksekusi
            compositeDisposable.add(disposable)
        }// memnbuat button menjadi aktif dan akan menajalan model noteViewModel serta mengaktifkan method savenote
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear() /// mengclear background thread
    }

    companion object {

        fun newInstance(): FragmentCreateNote {
            return FragmentCreateNote()// membuat instance fragment note
        }
    }
}