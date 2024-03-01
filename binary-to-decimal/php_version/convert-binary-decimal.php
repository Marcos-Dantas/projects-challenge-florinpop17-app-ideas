<?php
// file_get_contents caso eu post dados JSON.serializer()
// caso não, basta printar o que tem no $_POST com var_dump() ou print_r()
// transforme o json num objeto de classe stdClass
// acesse os elementos do objeto com ->
if($_SERVER['REQUEST_METHOD'] == 'POST'){
    $json_data = file_get_contents('php://input');
    $data = json_decode($json_data);
    $value = $data->value; 
    $string_cont = strlen($value);
    $sum = 0;
    $count = 0;

    // percorrer a string de tras pra frente
    for($i = $string_cont - 1; $i >= 0; $i--) {
        // calcular a potencia e somar os resultados
        $sum = $sum + (int)$value[$i] * pow(2, $count);
        $count++;
    }
    echo $sum;   
}