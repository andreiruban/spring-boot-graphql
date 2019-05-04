package app.dao

import app.dto.Author


class AuthorDao(private val authors: List<Author>) {

    fun getAuthor(id: String): Author? = authors.firstOrNull { author -> id == author.id }

}