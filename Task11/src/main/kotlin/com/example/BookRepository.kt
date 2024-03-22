package com.example

import com.example.Book

interface BookRepository {
    fun findAll(): List<Book>
    fun findById(id: String): Book?
    fun save(book: Book): Book
    fun delete(id: String)
}