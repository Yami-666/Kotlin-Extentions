fun <T> List<T>?.orEmptyMutable(): MutableList<T> = this?.toMutableList() ?: mutableListOf()

fun <T> Set<T>?.orEmptyMutable(): MutableSet<T> = this?.toMutableSet() ?: mutableSetOf()

fun <T> MutableCollection<T>.addIf(predicate: Boolean, whatToAdd: () -> T) {
    if (predicate) this.add(whatToAdd())
}

inline fun <T, K> Iterable<T>.distinctAndFilter(distinctBy: (T) -> K, filterBy: (T) -> Boolean): List<T> {
    val set = HashSet<K>()
    val list = ArrayList<T>()
    for (e in this) {
        val key = distinctBy(e)
        if (set.add(key) && filterBy(e))
            list.add(e)
    }
    return list
}

/**
* Uses sumWith from DoubleExt to avoid algebraic errors
* @see DoubleExt
*/
inline fun <T> Iterable<T>.sumByDoubleSafe(selector: (T) -> Double): Double {
    var sum: Double = 0.0
    for (element in this) {
        sum = sum.sumWith(selector(element))
    }
    return sum
}

fun <K, V> Iterable<Pair<K, V>>.toMutableMap(): MutableMap<K, V> {
    if (this is Collection) {
        return when (size) {
            0 -> mutableMapOf()
            1 -> mutableMapOf(if (this is List) this[0] else iterator().next())
            else -> toMap(LinkedHashMap<K, V>(size))
        }
    }
    return toMap(LinkedHashMap())
}
