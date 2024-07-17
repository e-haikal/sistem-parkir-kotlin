package main.kotlin.utils

// Object to handle user input
object InputHandler {
    // Function to get user input with a formatted prompt
    fun getInput(prompt: String): String {
        println("\n$prompt") // Menampilkan prompt dengan garis baru
        print("> ") // Menampilkan tanda untuk input
        return readLine() ?: ""
    }
}
