import kotlin.collections.Iterator

interface Iterator<T> {
    fun hasNext(): Boolean
    fun next(): T?
}

class Photo(public var name: String) {
}

class PhotoFrame : Iterable<Photo> {
    private val photos = mutableListOf<Photo>()
    fun addBook(book: Photo) {
        photos.add(book)
    }
    fun getLength() = photos.size
    fun getBookAt(index: Int) = photos[index]
    override fun iterator(): Iterator<Photo> = PhotoIterator(this)
}

class PhotoIterator(private val photoFrame: PhotoFrame) : Iterator<Photo> {
    private var index = 0
    override fun hasNext(): Boolean {
        return index < photoFrame.getLength()
    }
    override fun next(): Photo {
        return photoFrame.getBookAt(index++)
    }
}





fun main() {
    val photoFrame = PhotoFrame()
    photoFrame.addBook(Photo("Design Patterns"))
    photoFrame.addBook(Photo("Effective Java"))
    photoFrame.addBook(Photo("Clean Code"))
    for(photo in photoFrame) {
        println(photo.name)
    }
}