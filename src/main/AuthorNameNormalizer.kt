class AuthorNameNormalizer() {
    fun normalize(name: String): String {
        val splitNamesOnComma = name.trim().split(",")
        val splitName = splitNamesOnComma.first().split(" ")
        if (splitName.count() == 1) return name
        return "${splitName.last()}, ${splitName.first()}${middleNames(splitName)}${prefixSuffixSplit(splitNamesOnComma)}"
    }

    private fun prefixSuffixSplit(splitNamesOnComma: List<String>): String {
        return if (splitNamesOnComma.count() > 1) ",${splitNamesOnComma.last()}" else ""
    }

    private fun middleNames(splitName: List<String>): String {
        val middleNames = splitName.drop(1).dropLast(1)
        return buildString {
            middleNames.forEach { middleName ->
                append(initialiseName(middleName))
            }
        }
    }

    private fun initialiseName(splitName: String): String {
        val dot = if (splitName.length > 1) "." else ""
        return " ${splitName.first()}$dot"
    }
}
