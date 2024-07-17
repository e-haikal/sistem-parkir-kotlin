package main.kotlin.services

import main.kotlin.models.*
import main.kotlin.utils.InputHandler
import java.text.SimpleDateFormat

// Class to manage the parking service
class ParkingService {
    private val parkedVehicles: MutableList<Vehicle> = mutableListOf() // List to store parked vehicles

    // Function to park a vehicle
    fun parkVehicle() {
        try {
            println("\n=== Parkir Kendaraan ===")
            val plateNumber = InputHandler.getInput("Masukkan nomor plat kendaraan (XX XX XX) : ")

            // Menu untuk memilih tipe kendaraan
            print("\nPilih tipe kendaraan: (1 = Car / 2 = Bike / 3 = Truck) : ")

            val vehicleTypeInput = readLine()?.toIntOrNull() ?: 0
            val vehicleType = when (vehicleTypeInput) {
                1 -> "car"
                2 -> "bike"
                3 -> "truck"
                else -> throw IllegalArgumentException("Tipe kendaraan tidak valid.")
            }

            val entryTime = InputHandler.getInput("Masukkan jam masuk (HH:MM):") // Input waktu masuk

            val vehicle: Vehicle = when (vehicleType) {
                "car" -> Car(plateNumber, entryTime)
                "bike" -> Bike(plateNumber, entryTime)
                "truck" -> Truck(plateNumber, entryTime)
                else -> throw IllegalArgumentException("Tipe kendaraan tidak valid.")
            }

            parkedVehicles.add(vehicle)
            println("\n✅ ${vehicle.getVehicleInfo()} telah diparkir pada jam $entryTime.")
        } catch (e: Exception) {
            main.kotlin.utils.ExceptionHandler.handle(e)
        }
    }

    // Function to remove a parked vehicle
    fun removeVehicle() {
        try {
            println("\n=== Keluarkan Kendaraan ===")
            val plateNumber = InputHandler.getInput("Masukkan nomor plat kendaraan yang akan dikeluarkan:")
            val vehicle = parkedVehicles.find { it.plateNumber == plateNumber }
                ?: throw NoSuchElementException("Kendaraan dengan nomor plat $plateNumber tidak ditemukan.")

            val exitTime = InputHandler.getInput("Masukkan jam keluar (HH:MM):")
            vehicle.exitTime = SimpleDateFormat("HH:mm").parse(exitTime).time // Set exit time

            val fee = vehicle.calculateParkingFee()
            parkedVehicles.remove(vehicle)

            println("\n🚗 Kendaraan Dikeluarkan!")
            println("${vehicle.getVehicleInfo()} telah dikeluarkan pada jam $exitTime.")
            println("💰 Biaya parkir: Rp ${String.format("%.2f", fee)}")
        } catch (e: Exception) {
            main.kotlin.utils.ExceptionHandler.handle(e)
        }
    }

    // Function to display all parked vehicles
    fun displayParkedVehicles() {
        println("\n=== Kendaraan yang Diparkir ===")
        if (parkedVehicles.isEmpty()) {
            println("🚫 Tidak ada kendaraan yang diparkir.")
        } else {
            parkedVehicles.forEach {
                println("${it.getVehicleInfo()} - Waktu Masuk: ${it.entryTime}, Waktu Keluar: ${it.exitTime ?: "Masih Parkir"}")
            }
        }
    }

    // Function to search for a specific vehicle
    fun searchVehicle() {
        try {
            println("\n=== Cari Kendaraan ===")
            val plateNumber = InputHandler.getInput("Masukkan nomor plat kendaraan yang dicari:")
            val vehicle = parkedVehicles.find { it.plateNumber == plateNumber }
                ?: throw NoSuchElementException("Kendaraan dengan nomor plat $plateNumber tidak ditemukan.")
            println("🔍 ${vehicle.getVehicleInfo()} ditemukan di tempat parkir pada jam ${vehicle.entryTime}.")
        } catch (e: Exception) {
            main.kotlin.utils.ExceptionHandler.handle(e)
        }
    }

    // Function to display the total number of parked vehicles
    fun totalParkedVehicles() {
        println("\n=== Total Kendaraan yang Diparkir ===")
        println("📊 Total kendaraan yang diparkir: ${parkedVehicles.size}")
    }

    // Function to display parking fees for each type of vehicle
    fun displayParkingFees() {
        println("\n=== Biaya Parkir per Jam ===")
        println("1. 🚗 Mobil: Rp 5.000/jam")
        println("2. 🏍️ Motor: Rp 2.000/jam")
        println("3. 🚚 Truk: Rp 10.000/jam")
    }
}
