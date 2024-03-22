package com.example

import com.example.Book
import com.example.BookRepository

class BookService(private val repository: BookRepository) {
    fun getAllBooks(): List<Book> = repository.findAll()
    fun getBook(id: String): Book? = repository.findById(id)
    fun createBook(book: Book): Book = repository.save(book)
    fun updateBook(book: Book): Book = repository.save(book) // Допустим, что save обрабатывает и создание, и обновление
    fun deleteBook(id: String) = repository.delete(id)
}
