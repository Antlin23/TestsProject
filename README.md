Vällkommna till vårat grupp projekt.
För att köra programmet så kommer det behövvas postman för att testa både User och Task.

För att skapa en user så behöver du skriva:
POST localhost:8080/user
{
  "id": null,
  "name": "",
  "email": ""
}
För att hämta en user så behöver du skriva:
GET localhost:8080/user
Om du vill hämta med ett specifikt id så skriver du GET localhost:8080/user{id}

Om du vill uppdatera user så behöver du skriva:
PUT localhost:8080/user/{id}
{
  "id": null,
  "name": "",
  "email": "uppdaterat svar"
}
Om du vill ta bort en user så skriver du:
DELETE localhost:8080/user/{id}


Om du vill lägga till en task till en user använder du denna syntax och skriver följande:
I id skriver du id för usern som du vill koppla tasken till.
Post localhost:8080/task
{
    "taskTitle": "Lära din bäven återställa våtmarker",
    "taskComment": "hej",
    "isDone": false,
    "user": {
    "id": {id}
    }
}
Om du vill se alla tasks så skriver du
Get localhost:8080/task

Om du vill uppdatera task
inom id ska det stå id på tasken du vill uppdatera
Put localhost:8080/task/{id}
{
    "taskTitle": "Lära din bäven återställa våtmarker",
    "taskComment": "nytt hej",
    "isDone": false,
    "user": {
    "id": {id}
    }
}

Om du vill köra delete på en task
Inom id ska det stå taskens id
DELETE localhost:8080/task/{id}





