def get_diagonals(m, sort=False):
    if m == [] or len(m) == 1:
        return m
    diagonal_number = (len(m)+len(m[0]))-1
    row_index = len(m)-1
    column_index = 0
    diagonals = []
    for i in range(diagonal_number):
        if row_index < 0:
            c_index = column_index
        else:
            c_index = 0
        if row_index < 0:
            r_index = 0
        else:
            r_index = row_index
        current_diagonal = []
        while r_index < len(m) and c_index < len(m[0]):
            current_diagonal.append(m[r_index][c_index])
            r_index += 1
            c_index += 1
        if sort:
            if row_index < 0:
                c_index = column_index
            else:
                c_index = 0
            if row_index < 0:
                r_index = 0
            else:
                r_index = row_index
            current_diagonal.sort()
            d_index = 0
            while r_index < len(m) and c_index < len(m[0]):
                m[r_index][c_index] = current_diagonal[d_index]
                d_index += 1
                r_index += 1
                c_index += 1
        diagonals.append(current_diagonal)
        row_index -= 1
        if row_index < 0:
            column_index += 1
    return diagonals
        


if __name__ == "__main__":
    matrix = [
        [3,3,1,1],
        [2,2,1,2],
        [1,1,1,2]
    ]
    diagonals = get_diagonals(matrix, sort=True)
    print(matrix)
    
