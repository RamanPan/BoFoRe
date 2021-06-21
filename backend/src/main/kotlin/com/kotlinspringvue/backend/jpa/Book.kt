package com.kotlinspringvue.backend.jpa
import javax.persistence.*;
@Entity
@Table(name = "bok")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) var id: Long?,
    @Column(name = "author") var author: String?,
    @Column(name = "tittle") var tittle: String?,
    @Column(name = "genre") var genre: String?,
    @Column(name="comment")
    var commenta: String? = null,
    @Column(name="isread")
    var isRead: Boolean? = false
) {
    @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "users_books",
                joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "book_id", referencedColumnName = "id")]
        )
        var books: Collection<User>? = null
}