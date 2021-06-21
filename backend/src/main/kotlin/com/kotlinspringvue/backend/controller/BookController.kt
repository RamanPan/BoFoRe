package com.kotlinspringvue.backend.controller

import com.kotlinspringvue.backend.repository.BookRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.kotlinspringvue.backend.jpa.Book;
import com.kotlinspringvue.backend.model.NewBook
import com.kotlinspringvue.backend.web.response.ResponseMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = ["*"], maxAge = 3600)
class BookController {
    @Autowired
    lateinit var bookRepository: BookRepository;
    @GetMapping("/all")
    fun listAll(): List<Book?>? {
        return bookRepository.findAll().sortedBy { it.id }
    }
    @GetMapping("/allread")
    fun listAllRead(): List<Book?>? {
        return bookRepository.findByIsRead(true).sortedBy { it.id }
    }
    @GetMapping("/allnotread")
    fun listAllNotRead(): List<Book?>? {
        return bookRepository.findByIsRead(false).sortedBy { it.id }
    }
//    @GetMapping("/all/{id}")
//    fun getById(@PathVariable("id") book: Book?): Book? {
//        return book
//    }

    @GetMapping("/rand")
    fun randBook(): Book? {
        val random = Random()

        return listAllNotRead()?.let { random.nextInt(it.size) }?.let { listAll()?.get(it) };
    }
    @PostMapping("/add")
    fun create(@Valid @RequestBody book: NewBook?): ResponseEntity<*> {
        // Creating book
        val newbook = Book(
            0,
            book?.author!!,
            book.tittle!!,
            book.genre!!
        )
        bookRepository.save(newbook)
        return ResponseEntity(ResponseMessage("Book was added!"), HttpStatus.OK)
    }

    @PostMapping("/upcomm")
    fun updateComment(@Valid @RequestBody bookFromDb: Book?
    ): ResponseEntity<*> {
        bookFromDb.let {
            if (it != null) {
                bookRepository.save(it)
            }
        }
        return ResponseEntity(ResponseMessage("Comment was added!"), HttpStatus.OK)
    }
    @PostMapping("/upstat")
    fun updateStatus(@Valid @RequestBody bookFromDb: Book?
    ): ResponseEntity<*>? {
        bookFromDb.let {
            if (it != null) {
                bookRepository.save(it)
            }
        }
        return ResponseEntity(ResponseMessage("Status was changed!"), HttpStatus.OK)
    }


//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("{id}")
//    fun delete(@PathVariable("id") book: Book?) {
//        if (book != null) {
//            bookRepository.delete(book)
//        }
//    }


}