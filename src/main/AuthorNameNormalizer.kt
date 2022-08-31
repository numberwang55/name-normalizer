class AuthorNameNormalizer() {
    fun normalize(name: String): String {
        val splitName = name.trim().split(" ")
        if (splitName.count() == 1) return name
        return "${splitName.last()}, ${splitName.first()}${middleNames(splitName)}"
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
        return " ${splitName.first()}."
    }
}
