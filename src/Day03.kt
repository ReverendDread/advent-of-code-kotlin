fun main() {

    fun part1(data: List<String>, length: Int): Int {

        val gammaSb = StringBuilder()
        val epsilonSb = StringBuilder()

        for (position in 0 until length) {
            val count = count(data, position)
            gammaSb.append(if (count >= 0) '1' else '0')
            epsilonSb.append(if (count < 0) '1' else '0')
        }

        val gamma = Integer.parseInt(gammaSb.toString(), 2)
        val epsilon = Integer.parseInt(epsilonSb.toString(), 2)

        return gamma * epsilon
    }

    fun part2(data: List<String>, length: Int): Int {

        val co2Data = data.toMutableList()
        val oxygenData = data.toMutableList()

        for (position in 0 until length) {
            if (co2Data.size == 1 && oxygenData.size == 1)
                break
            if (co2Data.size != 1)
                prune(co2Data, position, false)
            if (oxygenData.size != 1)
                prune(oxygenData, position, true)
        }

        val oxygen = oxygenData.first().toInt(2)
        val co2 = co2Data.first().toInt(2)

        return co2 * oxygen
    }

    val textInput = readInput("Day03_test")
    println("------ TEST --------")
    var size = textInput[0].length
    println(part1(textInput, size))
    println(part2(textInput, size))
    println()

    println("----- RESULT -----")
    val input = readInput("Day03")
    size = input[0].length
    println(part1(input, size))
    println(part2(input, size))

}

fun count(data: List<String>, pos: Int): Int = data.sumOf { (if (it[pos] == '1') 1 else -1) as Int }

fun prune(data: MutableList<String>, pos: Int, pruneCo2: Boolean) {
    val count = count(data, pos)
    val pair = Pair(if (pruneCo2) '0' else '1', if (pruneCo2) '1' else '0')
    data.removeIf { it[pos] == if (count < 0) pair.first else pair.second }
}