fun Unique(array: Array<Int>): Int {
    if(array.isEmpty())
        return 0

    var count = 1
    var cur = array[0]
    for(element in array) {
        if(cur < element) {
            ++count
            cur = element
        }
    }
    return count
}

fun main() {
    //examples
    val numbers1: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val numbers2: Array<Int> = arrayOf(-1, -1, 0, 1, 2, 2, 3, 3, 4, 5)
    val numbers3: Array<Int> = arrayOf(10, 10, 100, 111, 111, 222, 222, 222, 222)
    println(Unique(numbers1)) // correct answer is 5
    println(Unique(numbers2)) // correct answer is 7
    println(Unique(numbers3)) // correct answer is 4
}
