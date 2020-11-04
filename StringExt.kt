fun String.orIfEmpty(input: () -> String): String {
    return if (this.isEmpty()) input.invoke()
    else this
}

fun String?.toDoubleOrZero(): Double {
    return this?.toDoubleOrNull() ?: 0.0
}

fun String?.toDoubleOrDefault(defaultValue: Double): Double {
    return this?.toDoubleOrNull() ?: defaultValue
}

fun String?.toIntOrZero(): Int {
    return this?.toIntOrNull() ?: 0
}

fun String?.toIntOrDefault(defaultValue: Int): Int {
    return this?.toIntOrNull() ?: defaultValue
}

fun String?.toLongOrZero(): Long {
    return this?.toLongOrNull() ?: 0L
}

fun String?.toLongOrDefault(defaultValue: Long): Long {
    return this?.toLongOrNull() ?: defaultValue
}

fun String.trimZeros() = this.trimStart('0')
