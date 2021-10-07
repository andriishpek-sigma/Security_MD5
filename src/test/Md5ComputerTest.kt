package test

import data.md5.Md5Computer
import data.md5.hash

class Md5ComputerTest(
    private val computer: Md5Computer
) {

    companion object {
        private val inputDataAndActualResults = mapOf(
            "" to "D41D8CD98F00B204E9800998ECF8427E",
            "a" to "0CC175B9C0F1B6A831C399E269772661",
            "abc" to "900150983CD24FB0D6963F7D28E17F72",
            "message digest" to "F96B697D7CB7938D525A2F31AAF161D0",
            "abcdefghijklmnopqrstuvwxyz" to "C3FCD3D76192E4007DFB496CCA67E13B",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789" to "D174AB98D277D9F5A5611C2C9F419D9F",
            "12345678901234567890123456789012345678901234567890123456789012345678901234567890" to "57EDF4A22BE3C955AC49DA2E2107B67A",
        )
    }

    fun execute() {
        var isSuccess = true
        inputDataAndActualResults.forEach { (input, expectedHash) ->
            val actualHash = computer.hash(input)
            if (!expectedHash.equals(actualHash, ignoreCase = true)) {
                isSuccess = false
                println(
                    "Hash for message \'$input\' is incorrect.\nExpected: $expectedHash\nActual:   $actualHash\n"
                )
            }
        }

        println(
            if (isSuccess) "\n\nAll tests passed!"
            else "Some of the tests failed!"
        )
    }

}