package com.study.devcommunityapi.domain.comment.repository

import com.study.devcommunityapi.domain.comment.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository: JpaRepository<Comment, Long> {

    @Query(value = "SELECT c FROM Comment c JOIN CommentHierarchy p ON c.id = p.ancestorCommentId WHERE c.post.id = :postId AND p.ancestorCommentId = p.descendantCommentId Order by c.createdAt")
    fun findAllByPostId(postId: Long) : List<Comment>

    @Query("SELECT c FROM Comment c JOIN CommentHierarchy p ON c.id = p.descendantCommentId WHERE p.ancestorCommentId = :commentId Order by c.createdAt")
    fun findByCommentIdWithDescendant(@Param("commentId") commentId: Long): List<Comment>

    @Query(value = "SELECT c FROM Comment c JOIN CommentHierarchy p ON c.id = p.descendantCommentId WHERE p.ancestorCommentId = :ancestorCommentId AND p.ancestorCommentId != p.descendantCommentId")
    fun findDescendantComments(@Param("ancestorCommentId") ancestorCommentId: Long) : List<Comment>
}