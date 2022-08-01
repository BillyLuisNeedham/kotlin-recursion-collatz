fun main(args: Array<String>) {
    (1..1000).forEach {
        println(it.collatz())
    }

}

fun Int.collatz() = collatzR(listOf(), this)

private tailrec fun collatzR(acc: List<Int>, x: Int): List<Int> =
    when {
        acc.isEmpty() -> collatzR(acc.plus(x), x)
        x.isEven() -> x.onEven(acc)
        else -> x.onOdd(acc)
    }

private fun Int.onOdd(acc: List<Int>): List<Int> =
    ((this * 3) + 1).let {
        val newAcc = acc.plus(it)
        if (it == 1) {
            newAcc
        } else {
            collatzR(newAcc, it)
        }
    }

private fun Int.onEven(acc: List<Int>): List<Int> =
    (this / 2).let {
        val newAcc = acc.plus(it)
        if (it == 1) {
            newAcc
        } else {
            collatzR(newAcc, it)
        }
    }

fun Int.isEven(): Boolean =
    this % 2 == 0
