package sort

import tj.mirboboev.util.Out

class InsertionSort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Out.array(sort(arrayOf(1, 66, 55)))
            Out.array(sort(arrayOf()))
            Out.array(sort(arrayOf(100)))
        }

        private fun sort(set: Array<Int>): Array<Int> {
            var i = 1

            while (i < set.size) {
                var j = i

                while (j > 0 && (set[j] < set[j - 1])) {
                    set[j] = set[j - 1].also { set[j - 1] = set[j] }
                    j -= 1
                }

                i++
            }

            return set;
        }
    }
}
