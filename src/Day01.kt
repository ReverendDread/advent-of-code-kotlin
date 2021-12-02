fun main() {

    fun part1(input: List<String>) = input.map(String::toInt).isLower()

    fun part2(input: List<String>) = input.map(String::toInt).windowed(3).map(List<Int>::sum).isLower()

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))

}

fun List<Int>.isLower(): Int = windowed(2).map { if (it[0] < it[1]) 1 else 0 }.sumOf { it }
