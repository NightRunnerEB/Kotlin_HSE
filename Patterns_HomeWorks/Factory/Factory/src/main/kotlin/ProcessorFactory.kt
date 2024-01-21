class ProcessorFactory (val number: String, val name: String,
                        val price: Double, val socketType: String,
                        val coreCount: Int, val clockSpeed: Double) : ComponentFactory() {
    override fun GetComponent(): IComponent {
        return Processor(number, name, price, socketType, coreCount, clockSpeed)
    }
}