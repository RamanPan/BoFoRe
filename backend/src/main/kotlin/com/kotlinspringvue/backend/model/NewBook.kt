package com.kotlinspringvue.backend.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import javax.persistence.Column

class NewBook : Serializable {
    @JsonProperty("author")
    var author: String? = null
    @JsonProperty("tittle")
    var tittle: String? = null
    @JsonProperty("genre")
    var genre: String? = null
    @JsonProperty("comment")
    var commenta: String? = null
    @JsonProperty("isread")
    var isRead: Boolean? = false

    constructor(author: String?, tittle: String?, genre: String?, commenta: String?, isRead: Boolean?) {
        this.author = author
        this.tittle = tittle
        this.genre = genre
        this.commenta = commenta
        this.isRead = isRead
    }

    constructor()
    constructor(author: String?, tittle: String?, genre: String?) {
        this.author = author
        this.tittle = tittle
        this.genre = genre
    }
}