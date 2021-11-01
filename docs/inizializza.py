# -*- coding: utf-8 -*-
__autor__ = "Francesco"
__version__ = "0101 2020/10/12"


# TODO modificare scrittura README encoding sbagliata
import time
import os


def cartelle(nomeProgetto):
    esiste = False
    head, tail = os.path.split(__file__)
    os.chdir(head)
    percorso = os.getcwd()
    cartella = percorso + "//" + "demartini_F_" + nomeProgetto

    esiste = os.path.isdir(cartella)

    if esiste == False:
        os.makedirs(cartella)

        perBin = cartella + "//" + "bin"
        os.makedirs(perBin)

        perDoc = cartella + "//" + "doc"
        os.makedirs(perDoc)

    else:
        esiste = "Progetto già esistente"
    return (esiste, perBin, perDoc)


def creaFile(perBin, perDoc, intJava, intRead):
    filejava = open(perBin + "//" + nomeProgetto + ".java", "w")
    filejava.write(intJava)
    filejava.close()

    filejava = open(perDoc + "//README.md", "w")
    filejava.write(intRead)
    filejava.close()
    return ()


boold = True
if __name__ == "__main__":
    if boold:
        print("Start")

    # Input
    nomeProgetto = input("inserire nome progetto: ")
    consegna = ""
    counterCapolinea = 1
    print("inserire consegna progetto: ")
    while (counterCapolinea < 3):

        inputConsegna = input()
        consegna += inputConsegna + "\n"

        # print(f"{counterCapolinea}  '{inputConsegna}'")

        if inputConsegna == "":
            counterCapolinea += 1
        else:
            counterCapolinea = 1

    # print(consegna)

    # Variabili
    intestazione_java = 'package demartini_F_' + nomeProgetto + '.bin;\n\n\
class ' + nomeProgetto + '{\n\
    public static void main(String[] args){\n\n\
        System.out.println("Start");\n\n\
        System.out.println("Hello, World");\n\n\
		System.out.println("End");\n\n\
    }\n\
}'

    intestazione_md = "# Program name: " + nomeProgetto + ".java\n\n\
---\n\n\
## Consegna\n\n" + consegna + "\n"


# Output
esiste, perBin, perDoc = cartelle(nomeProgetto)
creaFile(perBin, perDoc, intestazione_java, intestazione_md)
print(esiste)

if boold:
    print("End")
