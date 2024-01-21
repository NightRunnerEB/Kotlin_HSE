class MotherboardFactory (val number: String, val name: String,
                          val price: Double, val socketType: String,
                          val coreCount: Int, val clockSpeed: String): ComponentFactory() {
    override fun GetComponent(): IComponent {
        return Motherboard(number, name, price, socketType, coreCount, clockSpeed)
    }
}