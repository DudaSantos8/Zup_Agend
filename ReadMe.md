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
  "startDate": "2024-10-10",
  "endDate": "2024-10-10",
  "startTime": "09:30:00",
  "endTime": "09:30:00",
  "event":{
    "nameEvent": "Teste",
    "description": "Teste"
  }
}
```
See filtered events
GET /event
Route : localhost:8087/agend?numberOfDays={days}
Return: 
```json
{
  "startDate": "2024-10-10",
  "events": [
    {
      "idEvent": "VswwHs",
      "nameEvent": "Evento 1",
      "description": "Teste de evento",
      "startTime": "09:30:00",
      "activeEvent": false
    },
    {
      "idEvent": "plxqcT",
      "nameEvent": "Evento 2",
      "description": "Testando campos",
      "startTime": "09:30:00",
      "activeEvent": true
    }
  ]
}
```

Cancel or activate event
PATCH / event
Route : localhost:8087/agend/idEvent

Del event
DELETE / event
Route : localhost:8087/agend/idEvent