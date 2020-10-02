package com.jdeers.entities

import javax.persistence.*
import javax.validation.constraints.NotNull


//@Entity
//@Table(name = "book")
//class EBook {
//    constructor() {}
//    constructor(isbn: @NotNull String?, name: @NotNull String?, genre: Book?) {
//        this.isbn = isbn
//        this.name = name
//        this.genre = genre
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    var id: Long? = null
//
//    @Column(name = "name", nullable = false)
//    var name: @NotNull String? = null
//
//    @Column(name = "isbn", nullable = false)
//    var isbn: @NotNull String? = null
//
//    @ManyToOne
//    private var genre: Book? = null
//    fun getGenre(): Book? {
//        return genre
//    }
//
//    fun setGenre(genre: Book?) {
//        this.genre = genre
//    }
//
//    override fun toString(): String {
//        return "Book{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", isbn='" + isbn + '\'' +
//                ", genre=" + genre +
//                '}'
//    }
//}
