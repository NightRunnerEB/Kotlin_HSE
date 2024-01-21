class HardDrive(
    override val number: String,  override val name: String,
    override val price: Double, val capacity: Int,
    val rotationSpeed: Int
) : IComponent
