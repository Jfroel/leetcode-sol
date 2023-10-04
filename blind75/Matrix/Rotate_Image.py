class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """

        # flip left to right then swap on diagonals
        n = len(matrix)
        for row in matrix:
          for l in range(n/2):
            r = n-1-l
            t = row[l]
            row[l] = row[r]
            row[r] = t


        for row in range(n-1):
          for col in range(n-row-1):
            t = matrix[col][row]
            matrix[col][row] = matrix[n-row-1][n-col-1]
            matrix[n-row-1][n-col-1] = t