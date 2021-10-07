package test

import data.md5.CustomMd5Computer

fun main(args: Array<String>) {
    val test = Md5ComputerTest(
        CustomMd5Computer()
    )
    test.execute()
}