class AuthorNameNormalizer() {
    fun normalize(name: String): String {
        val splitName = name.trim().split(" ")
        if (splitName.count() == 1) return name
        return "${splitName.last()}, ${splitName.first()}${middleName(splitName)}"
    }

    private fun middleName(splitName: List<String>): String {
        var middleName = ""
        val dot = if (splitName.count() > 2 && splitName[1].length > 1) "." else ""
        if (splitName.count() > 2) middleName = " ${splitName[1].first()}$dot"
        return middleName
    }
}
