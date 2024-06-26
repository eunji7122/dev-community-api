package com.study.devcommunityapi.domain.comment.dto

import com.study.devcommunityapi.domain.comment.entity.CommentHierarchy
import com.study.devcommunityapi.domain.member.dto.MemberSummaryResponseDto
import java.time.LocalDateTime

data class CommentResponseDto(
    val id: Long,
    val contents: String,
    val commentHierarchies: List<CommentHierarchy>? = null,
    val member: MemberSummaryResponseDto,
    val heartCount: Int,
    val updatedAt: LocalDateTime?,
)
