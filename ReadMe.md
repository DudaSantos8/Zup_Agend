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
Cancel event
Patch /event
Route : localhost:8087/agend/idEvent

Delete event
delete /event
Route : localhost:8087/agend/idEvent