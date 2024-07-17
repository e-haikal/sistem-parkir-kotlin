import main.kotlin.services.ParkingService

// Main function for the Parking System application
fun main() {
    val parkingService = ParkingService()

    println("=== Selamat Datang di Sistem Parkir ===")

    while (true) {
        println("\n=== Sistem Parkir ===")
        println("🌟 Pilihan Menu:")
        println("1. Parkir Kendaraan")
        println("2. Keluarkan Kendaraan")
        println("3. Tampilkan Kendaraan yang Diparkir")
        println("4. Cari Kendaraan")
        println("5. Lihat Total Kendaraan yang Diparkir")
        println("6. Lihat Biaya Parkir")
        println("7. Keluar")

        print("\nSilakan masukkan menu pilihan Anda: (1 / 2 / 3 / 4 / 5 / 6 / 7) = ")

        val choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            1 -> parkingService.parkVehicle()
            2 -> parkingService.removeVehicle()
            3 -> parkingService.displayParkedVehicles()
            4 -> parkingService.searchVehicle()
            5 -> parkingService.totalParkedVehicles()
            6 -> parkingService.displayParkingFees()
            7 -> {
                println("👋 Terima kasih telah menggunakan sistem parkir. Selamat tinggal!")
                return
            }
            else -> println("⚠️ Pilihan tidak valid, silakan coba lagi.")
        }
    }
}
