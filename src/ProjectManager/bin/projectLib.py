# -*- coding: utf-8 -*-
__autor__="Francesco"
__version__="0101 2022/03/14"

import os, sys, json, glob, shutil
from pathlib import Path
from genericpath import isdir, isfile

exist = False
percorso, tail = os.path.split(__file__)
os.chdir(percorso)

# CONSTANTI
pathSeparation = "//"

def openJSON():
    try:
        f = open('../file/projectSettings.json', 'r+')
        return f
    except FileNotFoundError:
        with open('projectSettings.json', 'w') as f:
            json.dump({}, f, indent=4)
        return openJSON()
    except:
        exit(1)

def updateKeyJSON(key, value):
    f = openJSON()
    data = json.load(f)
    data[key] = value
    f.seek(0)
    json.dump(data, f, indent=4)
    f.truncate()
    f.close()

def updateJSON(dix):
    for key, value in dix.items():
        updateKeyJSON(key, value)

def getKeyValueJSON(key):
    f = openJSON()
    data = json.load(f)
    f.close()
    try:
        return data[key]
    except KeyError:
        return None

def getDixJSON():
    f = openJSON()
    data = json.load(f)
    f.close()
    return data

def rotate(lista: list, n):
    return lista[n:] + lista[:n]

def makeProjectDir(nomeProgetto, nomeCartella, binName, docName, fileName):
    cartella = percorso + pathSeparation + nomeCartella + nomeProgetto
    esiste = os.path.isdir(cartella)
    perBin = ""
    perDoc = ""
    perFile = ""

    if not esiste:
        os.makedirs(cartella)

        perBin = cartella + pathSeparation + binName
        os.makedirs(perBin)

        perDoc = cartella + pathSeparation + docName
        os.makedirs(perDoc)

        perFile = cartella + pathSeparation + fileName
        os.makedirs(perFile)

    else:
        esiste = "Progetto già esistente"
    return esiste, perBin, perDoc, perFile, cartella

def createJavaAndReadmeFile(perBin, perDoc, intJava, intRead, projectName, readmeName):
    try:
        filejava = open(perBin + pathSeparation +
                        projectName + ".java", "w")
        filejava.write(intJava)
        filejava.close()

        filejava = open(perDoc + pathSeparation + readmeName, "w")
        filejava.write(intRead)
        filejava.close()
    except IOError:
        return False
    return True


boold = True
if __name__ == "__main__":
    if boold:
        print("Start")

    dix = {}
    
    dix['nomeCartella'] = "demartini_F_"
    dix['readmeName'] = "README.md"
    dix['binName'] = "bin"
    dix['docName'] = "doc"
    dix['fileName'] = "file"

    updateJSON(dix)

    if boold:
        print("End")
