data class Patient(
    val id: Int,
    val name: String,
    val disease: String,
    var isAdmitted: Boolean = false
)

class Hospital {

    private val patients = mutableListOf<Patient>()

    fun addPatient() {
        print("Enter Patient ID: ")
        val id = readLine()!!.toInt()

        print("Enter Patient Name: ")
        val name = readLine()!!

        print("Enter Disease: ")
        val disease = readLine()!!

        patients.add(Patient(id, name, disease))
        println("Patient Added Successfully!\n")
    }

    fun viewPatients() {
        if (patients.isEmpty()) {
            println("No patients available.\n")
            return
        }

        println("\n Patient List:")
        for (p in patients) {
            println("ID: ${p.id}, Name: ${p.name}, Disease: ${p.disease}, Status: ${if (p.isAdmitted) "Admitted" else "Not Admitted"}")
        }
        println()
    }

    fun admitPatient() {
        print("Enter Patient ID to Admit: ")
        val id = readLine()!!.toInt()

        val patient = patients.find { it.id == id }

        if (patient == null) {
            println("Patient not found!\n")
        } else if (patient.isAdmitted) {
            println("Patient already admitted!\n")
        } else {
            patient.isAdmitted = true
            println("Patient Admitted Successfully!\n")
        }
    }

    fun dischargePatient() {
        print("Enter Patient ID to Discharge: ")
        val id = readLine()!!.toInt()

        val patient = patients.find { it.id == id }

        if (patient == null) {
            println("Patient not found!\n")
        } else if (!patient.isAdmitted) {
            println("Patient is not admitted!\n")
        } else {
            patient.isAdmitted = false
            println("Patient Discharged Successfully!\n")
           }
        }

    fun deletePatient() {
        print("Enter Patient ID to Delete: ")
        val id = readLine()!!.toInt()

        val removed = patients.removeIf { it.id == id }

        if (removed) {
            println("Patient Deleted Successfully!\n")
        } else {
            println("Patient not found!\n")
        }
    }
}

fun main() {

    val hospital = Hospital()
    while (true) {
        println("====== Hospital Management System ======")
        println("1. Add Patient")
        println("2. View Patients")
        println("3. Admit Patient")
        println("4. Discharge Patient")
        println("5. Delete Patient")
        println("6. Exit")
        print("Enter your choice: ")

        when (readLine()!!.toInt()) {
            1 -> hospital.addPatient()
            2 -> hospital.viewPatients()
            3 -> hospital.admitPatient()
            4 -> hospital.dischargePatient()
            5 -> hospital.deletePatient()
            6 -> {
                println("Exiting... Thank you!")
                break
            }
            else -> println("Invalid choice!\n")
        }
    }
}