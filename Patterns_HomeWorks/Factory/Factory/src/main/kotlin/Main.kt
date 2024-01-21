val motherboard = MotherboardFactory("MB123", "ASUS Prime X570", 150.0, "AM4", 1, "DDR4")
val processor = ProcessorFactory("CPU456", "Intel Core i7-9700K", 300.0, "LGA1151", 8, 3.6)
val hardDrive = HardDriveFactory("HDD789", "Seagate Barracuda", 80.0, 2000, 7200)


val factories: List<ComponentFactory> = listOf(
    motherboard,
    processor,
    hardDrive
)

fun print(factory : ComponentFactory?) {
    val component = factory?.GetComponent() ?: return
    println("Nomenclature number: ${component.number}")
    println("Name: ${component.name}")
    println("Price: ${component.price}")
    when (component) {
        is Motherboard -> {
            println("Socket Type: ${component.socketType}")
            println("Number of processors: ${component.processorCount}")
            println("Type of RAM: ${component.memoryType}")
        }
        is Processor -> {
            println("Socket Type: ${component.socketType}")
            println("Number of cores: ${component.coreCount}")
            println("Clock frequency: ${component.clockSpeed} GHz")
        }
        is HardDrive -> {
            println("Volume: ${component.capacity} GB")
            println("Rotation speed: ${component.rotationSpeed} RPM")
        }
    }
}

fun main() {
    for (factory in factories) {
        print(factory)
    }
    println("Enter number: ")
    val number = readln()
    for (factory in factories) {
        when (factory) {
            is MotherboardFactory -> {
                if (number.equals(factory.number)) {
                    print(factory)
                    break
                }
            }
            is ProcessorFactory -> {
                if (number.equals(factory.number)) {
                    print(factory)
                    break
                }
            }
            is HardDriveFactory -> {
                if (number.equals(factory.number)) {
                    print(factory)
                    break
                }
            }
        }
    }
}