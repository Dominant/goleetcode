package sort

import tj.mirboboev.util.Out

class SelectionSort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Out.array(sort(arrayOf(1, 66, 55)))
            Out.array(sort(arrayOf()))
            Out.array(sort(arrayOf(100)))
        }

        private fun sort(set: Array<Int>): Array<Int> {

            for (i in set.indices) {
                var min = i
                for (j in i until set.size step 1) {
                    if (set[j] < set[min]) {
                        min = j
                    }
                    set[i] = set[min].also { set[min] = set[i] }
                }
            }

            return set;
        }
    }
}
