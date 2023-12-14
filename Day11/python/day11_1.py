def expand_columns(matrix_2d) -> list[list[str]]:
    number_of_columns = len(matrix_2d)
    number_of_rows = len(matrix_2d[0])

    for column_index in range(0, number_of_columns):
        for row_index in range()

    return matrix_2d

def convert_to_2d_matrix(list_of_lines) -> list[list[str]]:
    matrix = []
    for line in list_of_lines:
        row = []
        for character in line:
            row.append(character)
        matrix.append(row)
    return matrix

def expand_rows(file_name) -> list[str]:
    with open(file_name) as file:
        first_lines = file.readlines()
        stripped_lines = []
        for line in first_lines:
            stripped_lines.append(line.strip())
            if line.strip() == '..........':
                stripped_lines.append(line.strip())
        return stripped_lines

if __name__ == "__main__":
    expanded_rows = expand_rows("small_input.txt")
    matrix_2d = convert_to_2d_matrix(expanded_rows)
    matrix_2d = expand_columns(matrix_2d)
    print(matrix_2d)