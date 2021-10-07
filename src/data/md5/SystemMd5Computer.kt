package data.md5

import java.security.MessageDigest

class SystemMd5Computer : Md5Computer {

    override fun hash(message: ByteArray): String {
        val md = MessageDigest.getInstance("MD5")
        md.update(message)
        val digest = md.digest()
        return digest.toHex().uppercase()
    }
}

fun ByteArray.toHex(): String = joinToString(separator = "") { eachByte -> "%02x".format(eachByte) }
