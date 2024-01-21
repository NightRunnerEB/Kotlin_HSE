class Motherboard(
    override val number: String, override val name: String,
    override val price: Double, val socketType: String,
    val processorCount: Int, val memoryType: String
) : IComponent
