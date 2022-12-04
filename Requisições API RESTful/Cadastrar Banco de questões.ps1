curl --location --request POST 'localhost:8080/centerquiz/api/banco-de-questoes' \
--header 'Content-Type: application/json' \
--data-raw '{
    "questionario": {
        "nome": "Nome teste 1",
        "tipoQuestionario": false,
        "dataInicio": null,
        "dataFim": null,
        "duracao": 3,
        "bancoDeQuestoes": null
    },
    "questoes": [
        {
            "titulo": "teste 6-1",
            "texto": "teste 6-1",
            "opcoes": [
                "Opção 1",
                "Opção 2"
            ],
            "respostas": [
                1,
                2
            ],
            "vezesPerguntado": 5,
            "bancoDeQuestoes": null
        },
        {
            "titulo": "teste 6-2",
            "texto": "teste 6-2",
            "opcoes": [
                "Opção 1",
                "Opção 2"
            ],
            "respostas": [
                1,
                2
            ],
            "vezesPerguntado": 5,
            "bancoDeQuestoes": null
        }
    ]
}'