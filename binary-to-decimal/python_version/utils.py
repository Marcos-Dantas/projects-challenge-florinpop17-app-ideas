def convert_to_decimal(value, value_in):
    result = 0
    cont = 0
    for v in value[::-1]:
        sum_v = int(v) * (2**cont)
        result = result + sum_v
        cont = cont + 1

    return result