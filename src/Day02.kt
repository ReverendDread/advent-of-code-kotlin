fun main() {

    fun part1(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        for (step in input) {
            val split = step.split(" ")
            val direction = split[0]
            val amount = split[1].toInt()
            when (direction) {
                "forward" -> horizontal+=amount
                "down" -> depth+=amount
                "up" -> depth-=amount
            }
        }
        return horizontal * depth
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0
        for (step in input) {
            val split = step.split(" ")
            val direction = split[0]
            val amount = split[1].toInt()
            when (direction) {
                "forward" -> {
                    horizontal+=amount
                    depth+=aim*amount
                }
                "down" -> aim+=amount
                "up" -> aim-=amount
            }
        }
        return horizontal * depth
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))

}