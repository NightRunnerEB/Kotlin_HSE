import org.jetbrains.exposed.sql.Table

object BooksTable : Table() {
    val id = varchar("id", 50).primaryKey()
    val title = varchar("title", 255)
    val content = text("content")
    val author = varchar("author", 50)
}