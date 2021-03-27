package com.mini.check


import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

// digunkan untuk memanggil ID dari layout xml
fun <X, Y> LiveData<X>.map(func: (source: X) -> Y) = Transformations.map(this, func)