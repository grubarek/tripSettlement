# tripSettlement
API wystawiające usługi restowe do rozliczeń międzyludzkich z podróży. Warstwowa implementacja usług zgodnie z JAVA EE.


System do zarządzania wydatkami
System pozwalający zapisywać wydatki grupy osób. 
Wydatki możliwe w różnych walutach
Każdy wprowadzony wydatek może być podzielony na osobę z grupy po równo lub w odpowiednich proporcjach. 
W wyniku dostajemy ilość nadpłaty oraz niedopłaty na jedną osobę. 
Do wydatków dopisywany jest ich czas
Wydatki można edytować usuwać 
Do wydatków dodana jest lokalizacja
Poprzez dodanie odpowiedniego argumentu w funkcji API dostajemy czas wykonywania skryptu.  
Front end responsywny. Wersja dla urządzeń mobilnych pozwala na tworzenie jednego rekordu jednocześnie. Wersja desktopowa pozwala na tworzenie wielu rekordów na jednym widoku. 
Każda grupa posiada 8 znakowy klucz identyfikujący

============================================================================================================================

Endpointy

POST /group  - dodanie grupy
Request:

```json
"groupName" : "nazwa grupy",
"users": [
	{
	"login": "",
},
{
"login" :"",
}

  ]
}
```
{


Response:

```json
{
	"groupKey" : "",
	"url" : "http://example.com/group_key_chars" //Dla zapraszania użytkowników
}
```
GET /group/groupKey - listowanie danych o grupie razem z listą użytkowników.
Response:
```json{
"groupKey":"12345678",
"groupName" : "nazwa grupy",
"creationDate":"",
"updateDate":"". //Ostatnia aktualizacja rekordu w grupie
"users": [
{
	"id":1, 
	"login": "",
},
{
"id":2, 
"login" :"",
}
]}
```
POST /group/groupKey/record - dodanie rekordu dla grupy
dane obrazka zapisujemy w bazie: jako tablica base64? W response można wystawić base64. Do zapisu potrzebny będzie jeszcze contentType.

Request:
```json
 {
"name" :"nazwa zdarzenia ",
"recordedDate":{
	"timestamp": "timestamp" /Data utworzenia offline. Z dokładnością do milisekund ()
}
"contentImage" : "base64",
"contentType" : "image/jpg",
"coordinates": {
	"lat" : float,
	"lon" : float
} 
"users":[ //Walidacja czy odpowiednia ilość użytkowników w grupie
	{"id":1,
	"value": 2.0,
	"currency": "PLN" //słownikowane kody walutowe ISO-4217,
	"participation": 1,
},
	{"id":2,
	"value": 0.0,
	"currency": "PLN" //słownikowane kody walutowe ISO-4217,
	"participation": 1,
},
]
}
```
Response:
```json{
"id": 1
"name":"Kawa",
"coordinates": {
	"lat" : float,
	"lon" : float
}, 
"recordedDate":{
	"timestamp": "timestamp"
},
 "users":[
	{"id":1,
	"value": 2.0,
	"currency": "PLN",
	"participation": 1
},
{"id":2,
	"value": 6.0,
	"currency": "PLN",
	"participation": 3},
{"id":3,
	"value": 2.0,
	"currency": "PLN",
	"participation": 1}
]
}
```
DELETE /group/groupKey/record/id
```json{
	"id": 1
}
```
PUT /group/groupKey/record - edycja rekordu dla grupy

```json
 {
"id": 1,
"name" :"nazwa zdarzenia ",
"recordedDate":{
	"timestamp": "timestamp" /Data utworzenia offline. Z dokładnością do milisekund ()
}
"contentImage" : "base64",
"contentType" : "image/jpg",
"coordinates": {
	"lat" : float,
	"lon" : float
} 
"users":[ //Walidacja czy odpowiednia ilość użytkowników w grupie
	{"id":1,
	"value": 2.0,
	"currency": "PLN" //słownikowane kody walutowe ISO-4217,
	"participation": 1,
},
	{"id":2,
	"value": 0.0,
	"currency": "PLN" //słownikowane kody walutowe ISO-4217,
	"participation": 1,
},
]
}

```
Response:
Zmodyfikowany rekord. 




GET /group/groupKey/record?sort=desc  - listowanie wszystkich wpisów + sortowanie po dacie
```json
{
"groupName":"nazwa",
"records":[
{
"id": 1
"name":"Kawa",
"coordinates": {
	"lat" : float,
	"lon" : float
}, 
"recordedDate":{
	"timestamp": "timestamp"
},
 "users":[
	{"id":1,
	"value": 2.0,
	"currency": "PLN",
	"participation": 1
},
{"id":2,
	"value": 6.0,
	"currency": "PLN",
	"participation": 3},
{"id":3,
	"value": 2.0,
	"currency": "PLN",
	"participation": 1}
]
},
{
"id": 2,
"name":"Pizza",
"coordinates": {
	"lat" : float,
	"lon" : float
}, 
"recordedDate":{
	"timestamp": "timestamp"
},
 "users":[
	{"id":1,
	"value": 2.0,
	"currency": "PLN",
	"participation": 1
},
{"id":2,
	"value": 6.0,
	"currency": "PLN",
	"participation": 3},
{"id":3,
	"value": 2.0,
	"currency": "PLN",
	"participation": 1}
]
}
]}

```
GET /group/groupKey/summary - zagregowane dane wyściowe z podsumowaniem ile kto ma zapłacić.
```json
{
"groupId": 1,
"summaryCost": 50,
"users":
[{
"id":1,
"toPay": 25,
"overpayment" :0, lub null
"curenncy" :"PLN", -- nie wiem czy to potrzebne możemy przyjąć  rozliczanie tylko w zł.
},
{
"id":2,
"toPay": 0,
"overpayment" :50,
"curenncy" :"zł", -- nie wiem czy to potrzebne możemy przyjąć rozliczanie tylko w zł.
},
{
"id":3,
"toPay": 25,
"curenncy" :"zł", -- nie wiem czy to potrzebne możemy przyjąć rozliczanie tylko w zł.
}]
}
```


Dodatkowy parametr `?time`  powoduje dodanie do responsu pola time określa czas wykonywania skryptu. 
