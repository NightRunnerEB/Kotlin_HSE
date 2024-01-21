class Processor(
    override val number: String,
    override val name: String,
    override val price: Double,
    val socketType: String,
    val coreCount: Int,
    val clockSpeed: Double
) : IComponent
