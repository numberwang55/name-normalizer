class AuthorNameNormalizer() {
    fun normalize(name: String): String {
        val splitName = name.trim().split(" ")
        if (splitName.count() == 1) return name
        val dot = if (splitName.count() > 2) "." else ""
        return "${splitName.last()}, ${splitName.first()}${middleName(splitName)}$dot"
    }

    private fun middleName(splitName: List<String>): String {
        var middleName = ""
        if (splitName.count() > 2) middleName = " ${splitName[1].first()}"
        return middleName
    }
}
