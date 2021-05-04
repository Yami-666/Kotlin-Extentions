fun MutableLiveData<Boolean>.revert() {
    try {
        value?.let {
            value = !it
        }
    } catch (e: IllegalStateException) {
        //pls add logging here
    }
}

fun MutableLiveData<Boolean>.revertAsync() {
    value?.let {
        postValue(!it)
    }
}

inline fun <X, Y> LiveData<X>.mutableSwitchMap(
        crossinline transform: (X) -> LiveData<Y>
): MutableLiveData<Y> = this.switchMap(transform) as MutableLiveData<Y>
