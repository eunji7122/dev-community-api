package com.study.devcommunityapi.common.exception

class InvalidInputException (
    val fieldName: String = "",
    message: String = "Invalid Input"
) : RuntimeException(message)