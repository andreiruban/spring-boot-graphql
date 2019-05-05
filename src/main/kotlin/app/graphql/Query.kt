package app.graphql

import app.dao.AuthorDao
import app.dao.PostDao
import app.dto.Author
import app.dto.Post
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.coxautodev.graphql.tools.GraphQLResolver
import java.util.*


class Query(private val postDao: PostDao?) : GraphQLQueryResolver {

    fun getRecentPosts(count: Int, offset: Int): List<Post>? {
        return postDao?.getRecentPosts(count, offset)
    }
}

class PostResolver(private val authorDao: AuthorDao) : GraphQLResolver<Post> {

    fun getAuthor(post: Post): Author? {
        return authorDao.getAuthor(post.authorId!!)
    }
}

class AuthorResolver(private val postDao: PostDao) : GraphQLResolver<Author> {

    fun getPosts(author: Author): List<Post> {
        return postDao.getAuthorPosts(author.id!!)
    }
}

class Mutation(private val postDao: PostDao) : GraphQLMutationResolver {

    fun writePost(title: String, text: String, category: String, author: String): Post {
        val post = Post()
        post.id = UUID.randomUUID().toString()
        post.title = title
        post.text = text
        post.category = category
        post.authorId = author
        postDao.savePost(post)

        return post
    }
}