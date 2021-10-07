package app

import data.md5.CustomMd5Computer
import data.md5.Md5Computer
import data.md5.hash

class App {

    companion object {
        private val inputData = listOf(
            "",
            "a",
            "abc",
            "message digest",
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789",
            "12345678901234567890123456789012345678901234567890123456789012345678901234567890",
        )
    }

    private val computer: Md5Computer = CustomMd5Computer()

    fun execute() {
        inputData
            .map { it to computer.hash(it) }
            .joinToString(separator = "\n\n") { data ->
                "Input: ${data.first}\nHash:  ${data.second}"
            }
            .let { print(it) }
    }

}