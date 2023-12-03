fun main() {
    var n = readln().toInt()
    val matrix = Array(n) {
        Array(n) { (0..10).random()}
    }

    for (line: Array<Int> in matrix) {
        for (num: Int in line) {
            print("$num  ")
        }
        print('\n')
    }
    --n
    
    var curr: Int
    var sum = 0
    for ((index, line) in matrix.withIndex()) {
        curr = (n - index) + 1
        if (curr <= n) {
            sum += line[curr]
        }
    }
    
    print("The sum of the numbers under the side diagonal: $sum")
}
