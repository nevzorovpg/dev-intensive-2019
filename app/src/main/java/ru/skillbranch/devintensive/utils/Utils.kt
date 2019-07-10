package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName : String?) : Pair<String?, String?> {
        val parts: List<String>? =  fullName?.split(" ")

        val firstName = parts?.getOrNull(0)?.ifEmpty { null }
        val lastName = parts?.getOrNull(1)?.ifEmpty { null }
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String{

        var transLiterationPayload: String = ""

        for (char in payload) {
            transLiterationPayload += when {
                char.isUpperCase()-> transliteralCharConverter(char.toLowerCase()).capitalize()
                else -> transliteralCharConverter(char.toLowerCase())}
        }
        return transLiterationPayload.replace(" ", divider)
    }

    fun transliteralCharConverter(charPart: Char): String = when(charPart){
        'а' -> "a"
        'б' -> "b"
        'в' -> "v"
        'г' -> "g"
        'д' -> "d"
        'е' -> "e"
        'ё' -> "e"
        'ж' -> "zh"
        'з' -> "z"
        'и' -> "i"
        'й' -> "i"
        'к' -> "k"
        'л' -> "l"
        'м' -> "m"
        'н' -> "n"
        'о' -> "o"
        'п' -> "p"
        'р' -> "r"
        'с' -> "s"
        'т' -> "t"
        'у' -> "u"
        'ф' -> "f"
        'х' -> "h"
        'ц' -> "c"
        'ч' -> "ch"
        'ш' -> "sh"
        'щ' -> "sh'"
        'ъ' -> ""
        'ы' -> "i"
        'ь' -> ""
        'э' -> "e"
        'ю' -> "yu"
        'я' -> "ya"
        else -> charPart.toString()
    }


    fun toInitials(firstName: String?, lastName: String?): String?{
        val firstN: String = firstName?.trimIndent()?.capitalize()?.getOrNull(0)?.toString() ?: ""
        val lastN: String = lastName?.trimIndent()?.capitalize()?.getOrNull(0)?.toString() ?: ""
        return "$firstN$lastN".ifEmpty { null }
    }
}

