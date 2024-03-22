package com.example.plugins

import com.example.Book
import com.example.BookService
import ExposedBookRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    val bookService = BookService(ExposedBookRepository())

    routing {
        openAPI {
            info {
                version = "1.0"
                title = "Book API"
                description = "API for managing books"
            }

            route("/books") {
                get {
                    tags = listOf("Book")
                    summary = "Get all books"
                    description = "Retrieve a list of all books"
                    response<List<Book>>(HttpStatusCode.OK) {
                        description = "Successful operation"
                    }
                }
                get("/{id}") {
                    tags = listOf("Book")
                    summary = "Get a book by id"
                    description = "Retrieve a single book by its id"
                    parameter<PathParameter, String>("id") {
                        description = "ID of book to return"
                    }
                    response<Book>(HttpStatusCode.OK) {
                        description = "Successful operation"
                    }
                    response<Unit>(HttpStatusCode.NotFound) {
                        description = "Book not found"
                    }
                }
                post {
                    tags = listOf("Book")
                    summary = "Add a new book"
                    description = "Add a new book to the collection"
                    requestBody<Book> {
                        description = "Book object that needs to be added to the store"
                        required = true
                    }
                    response<Book>(HttpStatusCode.Created) {
                        description = "Book created"
                    }
                }
                put {
                    tags = listOf("Book")
                    summary = "Update an existing book"
                    description = "Update an existing book identified by its id"
                    requestBody<Book> {
                        description = "Book object that needs to be updated"
                        required = true
                    }
                    response<Book>(HttpStatusCode.OK) {
                        description = "Book updated"
                    }
                    response<Unit>(HttpStatusCode.NotFound) {
                        description = "Book not found"
                    }
                }
                delete("/{id}") {
                    tags = listOf("Book")
                    summary = "Delete a book"
                    description = "Delete a book identified by its id"
                    parameter<PathParameter, String>("id") {
                        description = "ID of the book that needs to be deleted"
                    }
                    response<Unit>(HttpStatusCode.OK) {
                        description = "Book deleted"
                    }
                    response<Unit>(HttpStatusCode.NotFound) {
                        description = "Book not found"
                    }
                }
            }
        }
    }
}
