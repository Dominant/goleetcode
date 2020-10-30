package search

data class Node(val left: Node?, val right: Node?, val value: Int)

class BinarySearchTree {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val node = Node(
                Node(
                    null,
                    Node(null, null, 8),
                    5
                ),
                Node(null, null, 15),
                10
            )
            println(binarySearch(node, 15))
            println(binarySearch(node, 8))
        }

        private fun binarySearch(tree: Node?, searchValue: Int): Int {
            if (tree == null) return -1

            if (tree.value == searchValue) {
                return 1
            }

            return if (tree.value > searchValue) {
                binarySearch(tree.left, searchValue)
            } else {
                binarySearch(tree.right, searchValue)
            }
        }
    }
}
