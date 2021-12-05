class Submarine {
    private var horizontalPosition = 0
    private var depth = 0
    private var aim = 0

    fun move(moves: List<Move>): Position {
        moves.forEach {
            when(it.direction) {
                "forward" -> {
                    horizontalPosition += it.value
                    depth += aim * it.value
                }
                "down" -> aim += it.value
                "up" -> aim -= it.value
            }
        }
        return Position(horizontalPosition, depth)
    }
}
