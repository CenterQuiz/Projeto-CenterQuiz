curl --location --request POST 'localhost:8080/centerquiz/api/questionario' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome": "Nome teste 1",
    "tipoQuestionario": false,
    "dataInicio": null,
    "dataFim": null,
    "duracao": 3
}'