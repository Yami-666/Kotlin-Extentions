/**
* Helper nullability function
*/
inline fun <reified T> T?.orIfNull(input: () -> T): T {
  return this ?: input()
}

/**
* get Enum from String
* */
inline fun <reified T : Enum<*>> enumValueOrNull(name: String): T? =
T::class.java.enumConstants.firstOrNull { it.name == name }

inline fun <reified T : Enum<*>> enumValueOrDefault(name: String, default: T): T =
T::class.java.enumConstants.firstOrNull { it.name == name } ?: default

/**
* try default fun realisation
*/
fun <T : Any> tryOrDefault(tryFunc: () -> T, defaultIfCatches: T): T {
  return try {
    tryFunc()
    } catch (e: Exception) {
      Logg.e { "tryOrDefault exception: ${e.message}" }
      defaultIfCatches
    }
}

fun <T : Any> tryOrNull(tryFunc: () -> T): T? {
    return try {
        tryFunc()
    } catch (e: Exception) {
        Logg.e { "tryOrNull exception: ${e.message}" }
        null
    }
}

fun tryOrEmpty(tryFunc: () -> String): String {
  return tryOrDefault({ tryFunc() }, "")
}

fun tryOrNow(tryFunc: () -> Date): Date {
  return tryOrDefault({ tryFunc() }, Date())
}

/**
* unsafe lazy delegate realisation
*/
inline fun <reified T, reified R> R.unsafeLazy(noinline init: () -> T): Lazy<T> {
  return lazy(LazyThreadSafetyMode.NONE, init)
}
