package main.kotlin.utils

// Object to handle exceptions
object ExceptionHandler {
    // Function to handle exceptions and print error messages
    fun handle(e: Exception) {
        println("Terjadi kesalahan: ${e.message}")
    }
}
