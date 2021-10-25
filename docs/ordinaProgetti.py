# -*- coding: utf-8 -*-
__autor__="Francesco"
__version__="0101 2020/10/12"
import time, os, shutil, glob
from inizializza import *

def rotate(l, n):
    return l[n:] + l[:n]

boold = True
if __name__== "__main__":
    if boold:
        print ("Start")
    
    head, tail = os.path.split(__file__)
    os.chdir(head)
    percorso = os.getcwd() 
    
    


    vettFile = glob.glob('*.java')
    for f in vettFile:
        intestazione_md = "# Program name: " + f + "\n\
---\n\n\
## Consegna\n _________________"
        nomeProgetto = (f.split("."))[0]
        esiste,perBin,perDoc = cartelle(nomeProgetto)

        filejava = open(perDoc+"//README.md","w")
        filejava.write(intestazione_md)
        filejava.close()



        fjava = open(f,"r")
        vRighe = fjava.readlines()
        fjava.close()

        vRighe.append("package " + "demartini_F_" + nomeProgetto + ".bin;\n\n\n")
        vRighe = rotate(vRighe,-1)

        fjava = open(f,"w")
        fjava.writelines(vRighe)
        fjava.close()

        shutil.move(percorso + "\\" + f, perBin)

    if boold:
        print ("End")
