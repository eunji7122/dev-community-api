package com.study.devcommunityapi.common.util.dto

data class PageRequestDto(
    val page: Int = 1,
    val size: Int = 5,
    val orderCriteria: String = "updatedAt",
    val searchKeyword: String = ""
)
