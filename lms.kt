data class Book(
    val id: Int,
    val name: String,
    val author: String,
    var isIssued: Boolean = false
)

class Library {

    private val books = mutableListOf<Book>()

    fun addBook() {
        print("Enter Book ID: ")
        val id = readLine()!!.toInt()

        print("Enter Book Name: ")
        val name = readLine()!!

        print("Enter Author Name: ")
        val author = readLine()!!

        books.add(Book(id, name, author))
        println("Book Added Successfully!\n")
    }

    fun viewBooks() {
        if (books.isEmpty()) {
            println("No books available.\n")
            return
        }

        println("\n Book List:")
        for (book in books) {
            println("ID: ${book.id}, Name: ${book.name}, Author: ${book.author}, Status: ${if (book.isIssued) "Issued" else "Available"}")
        }
        println()
    }

    fun issueBook() {
        print("Enter Book ID to Issue: ")
        val id = readLine()!!.toInt()

        val book = books.find { it.id == id }

        if (book == null) {
            println("Book not found!\n")
        } else if (book.isIssued) {
            println("Book already issued!\n")
        } else {
            book.isIssued = true
            println("Book Issued Successfully!\n")
        }
    }

    fun returnBook() {
        print("Enter Book ID to Return: ")
        val id = readLine()!!.toInt()

        val book = books.find { it.id == id }

        if (book == null) {
            println(" Book not found!\n")
        } else if (!book.isIssued) {
            println("Book was not issued!\n")
        } else {
            book.isIssued = false
            println("Book Returned Successfully!\n")
        }
    }

    fun deleteBook() {
        print("Enter Book ID to Delete: ")
        val id = readLine()!!.toInt()

        val removed = books.removeIf { it.id == id }

        if (removed) {
            println("Book Deleted Successfully!\n")
        } else {
            println("Book not found!\n")
        }
    }
}

fun main() {
    val library = Library()

    while (true) {
        println("====== Library Management System ======")
        println("1. Add Book")
        println("2. View Books")
        println("3. Issue Book")
        println("4. Return Book")
        println("5. Delete Book")
        println("6. Exit")
        print("Enter your choice: ")

        when (readLine()!!.toInt()) {
            1 -> library.addBook()
            2 -> library.viewBooks()
            3 -> library.issueBook()
            4 -> library.returnBook()
            5 -> library.deleteBook()
            6 -> {
                println("Exiting... Thank you!")
                break
            }
            else -> println("Invalid choice!\n")
        }
    }
}