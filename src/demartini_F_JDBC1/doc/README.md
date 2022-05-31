# Program name: JDBC1.java

---

## Consegna
    local.marconivr.it
    utfrasi pwfrasi
    
    comandi visti
    
    CREATE DATABASE IF NOT EXISTS dbfrasi;
    
    use dbfrasi;
    
    drop user if exists 'utfrasi'@'%';
    drop user if exists 'utfrasi'@'localhost';
    DROP TABLE IF EXISTS frase;
    DROP TABLE IF EXISTS autore ;
    
    
    CREATE TABLE IF NOT EXISTS autore (
      id INT NOT NULL AUTO_INCREMENT,
      username VARCHAR(25) unique NOT NULL,
      nome VARCHAR(30) NULL,
      cognome VARCHAR(30) NOT NULL,
      PRIMARY KEY (id));
    
    CREATE TABLE IF NOT EXISTS frase (
      id INT NOT NULL AUTO_INCREMENT,
      titolo VARCHAR(50) NOT NULL,
      frasecompleta TEXT NOT NULL,
      lastupdate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
      idaut INT NOT NULL,
      PRIMARY KEY (id),
      CONSTRAINT
        FOREIGN KEY (idaut)
        REFERENCES autore (id)
    );
    
    CREATE USER 'utfrasi'@'%' IDENTIFIED
     with mysql_native_password by 'ì' ;
     
    CREATE USER 'utfrasi'@'localhost' IDENTIFIED
     with mysql_native_password by 'pwfrasi' ;
    
    GRANT ALL PRIVILEGES ON dbfrasi.* TO 'utfrasi'@'%';
    GRANT ALL PRIVILEGES ON dbfrasi.* TO 'utfrasi'@'localhost';
    
    INSERT INTO autore (id, username, nome, cognome ) VALUES
    (100, 'ldecarli', 'Lorenzo', 'De Carli'),
    (101, 'iventuri', 'Irene', 'Venturi'),
    (102, 'srossi', 'Stefania', 'Rossi'),
    (103, 'gcobello', 'Grazia', 'Cobello')
    ;
    INSERT INTO autore (username, nome, cognome ) VALUES
    ('zpedio', 'Zaki', 'Pedio');
    
    INSERT INTO autore (username, nome, cognome ) VALUES
    ('psecchi', 'Pietro', 'Secchi');
    
    INSERT INTO frase (id, titolo, frasecompleta, lastupdate, idaut) VALUES
    (1000, 'info 1', 'meglio, molto meglio l''informatica...', '2022-05-08', 100),
    (1001, 'speck', 'i thread non condividevano lo stack', '2022-03-08 22:28:14', 102);
    
    
    #tutti gi autori
    select * from autore
    
    
    #le frasi lorenzo
    select * from frase join autore on frase.idaut=autore.id
    
    #aggiungi una parola ad una frase
    update frase set frasecompleta=concat(frasecompleta,' parola') where id=1001
    
    update frase set lastupdate=now() where id=1001