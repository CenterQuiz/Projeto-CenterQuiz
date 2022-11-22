curl --location --request POST 'localhost:8080/centerquiz/api/questao' \
--header 'Content-Type: application/json' \
--data-raw '{
        "titulo": "Titulo 2",
        "texto": "Texto 2",
        "opcoes": [
            "Opção 1",
            "Opção 2"
        ],
        "respostas": [
            1,
            2
        ],
        "vezesPerguntado": 4,
        "bancoDeQuestoes": null
    }'