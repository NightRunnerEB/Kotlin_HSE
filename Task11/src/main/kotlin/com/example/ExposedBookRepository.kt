import com.example.Book
import com.example.BookRepository
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class ExposedBookRepository : BookRepository {

    init {
        transaction {
            SchemaUtils.create(BooksTable)
        }
    }

    override fun findAll(): List<Book> = transaction {
        BooksTable.selectAll().map { it.toBook() }
    }

    override fun findById(id: String): Book? = transaction {
        BooksTable.select { BooksTable.id eq id }.singleOrNull()?.toBook()
    }

    override fun save(book: Book): Book = transaction {
        // Обновление или вставка новой книги
        BooksTable.insert {
            it[id] = book.id
            it[title] = book.title
            it[content] = book.content
            it[author] = book.author
        }
        book
    }

    override fun delete(id: String): Unit = transaction {
        BooksTable.deleteWhere { BooksTable.id eq id }
    }

    private fun ResultRow.toBook(): Book = Book(
        id = this[BooksTable.id],
        title = this[BooksTable.title],
        content = this[BooksTable.content],
        author = this[BooksTable.author]
    )
}
