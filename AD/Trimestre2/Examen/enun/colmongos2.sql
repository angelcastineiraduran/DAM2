
use test
db.persoas.drop()
var pers=
[
{_id:"361a",enfermidade:"diabete"},
{_id:"362b",enfermidade:"diabete"},
{_id:"363c",enfermidade:"lupus"},
{_id:"364d",enfermidade:"hipertension"}
]
db.enfermidades.drop();
var enfer=
[
{_id:"diabete",maxcolesterolsemanal:1.75},
{_id:"hipertension",maxcolesterolsemanal:1.4},
{_id:"cardiovascular",maxcolesterolsemanal:1.05},
{_id:"hipotiroidismo",maxcolesterolsemanal:1.225},
{_id:"lupus",maxcolesterolsemanal:1.085}
]

db.persoas.insert(pers)
db.enfermidades.insert(enfer)

