curl --location --head 'localhost:8080/centerquiz/api/banco-de-questoes' \
--header 'Content-Type: application/json' \
--data-raw '{
    "questionario": {
        "id": 10,
        "nome": "Nome teste 1",
        "tipoQuestionario": false,
        "dataInicio": null,
        "dataFim": null,
        "duracao": 3,
        "bancoDeQuestoes": null
    },
    "questoes": [
        {
            "titulo": "teste banco de questões 1",
            "texto": "teste banco de questões 1",
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