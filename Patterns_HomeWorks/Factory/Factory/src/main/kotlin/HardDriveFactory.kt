class HardDriveFactory (val number: String, val name: String,
                        val price: Double, val capacity: Int,
                        val rotationSpeed: Int) : ComponentFactory() {
    override fun GetComponent(): IComponent {
        return HardDrive(number, name, price, capacity, rotationSpeed)
    }
}