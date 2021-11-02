# Program name: Stato.java

---

## Consegna

Uno Stato è caratterizzato dal nome, dalla superficie (in km2) e dalla popolazione (in milioni di abitanti). Per ogni
Stato si possono richiamare i seguenti metodi:

- costruttori con e senza parametri
- set e get
- toString()
- un metodo per calcolare la densità di popolazione (in abitanti per km2)
- il metodo confronta(Stato s) che ritorni un valore negativo se l’oggetto chiamante ha una densità di popolazione
  minore di s, zero se l’oggetto chiamante ha una densità di popolazione uguale ad s, un valore positivo altrimenti.
- il metodo confronta(double a, double b) che ritorni true se la densità dell’oggetto chiamante è compresa tra a e b.

**Creare nell’ordine:**

- diagramma di classe UML;
- il main della classe StatoTest in cui:
- viene creato lo Stato Italia con superficie 302073 km2 e 60,36 milioni di abitanti;
    - viene creato lo Stato Francia con superficie 675417 km2 e 68,30 milioni di abitanti;
    - vengono stampati a video i dati dei due Stati e le relative densità di abitanti;
    - viene stampato a video il nome dello Stato più densamente popolato;
    - viene stampato a video se la Francia ha una densità di popolazione compresa tra 0 e 100 abitanti per km2.
- la classe Stato.  
