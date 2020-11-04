fun <T> List<T>?.orEmptyMutable(): MutableList<T> = this?.toMutableList() ?: mutableListOf()

fun <T> Set<T>?.orEmptyMutable(): MutableSet<T> = this?.toMutableSet() ?: mutableSetOf()

fun <T> MutableCollection<T>.addIf(predicate: Boolean, whatToAdd: () -> T) {
    if (predicate) this.add(whatToAdd())
}
