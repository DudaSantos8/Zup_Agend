# Zup Agend

![](.dev/static/gif_de_conexao.gif)

-------
## UML of project

![](.dev/static/Agend.png)

## API Contract

Add new event
POST /event
```json
{
  "dataInicio": Date,
  "dataFim": Date,
  "horaInicio": Time,
  "horaFim": Time,
  "evento": {
    "nomeEvento": String,
    "descricao": String,
  }
}
```
Cancel event
Put /event
```json

```