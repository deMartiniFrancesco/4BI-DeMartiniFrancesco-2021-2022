# -*- coding: utf-8 -*-
__autor__="Francesco"
__version__="0101 2022/03/14"

import os, json
from genericpath import isdir, isfile

exist = False
percorso, tail = os.path.split(__file__)
os.chdir(percorso)

# CONSTANTI
pathSeparation = "//"

def open_JSON(fileName):
    try:
        f = open('../file/' + fileName, 'r+')
        return f
    except FileNotFoundError:
        with open('../file/' + fileName, 'w') as f:
            json.dump({}, f, indent=4)
        return open_JSON(fileName)
    except:
        exit(1)

def update_key_JSON(fileName, key, value):
    f = open_JSON(fileName)
    data = json.load(f)
    data[key] = value
    f.seek(0)
    json.dump(data, f, indent=4)
    f.truncate()
    f.close()

def update_JSON(fileName, dix):
    for key, value in dix.items():
        update_key_JSON(fileName, key, value)

def get_key_value_JSON(fileName, key):
    f = open_JSON(fileName)
    data = json.load(f)
    f.close()
    try:
        return data[key]
    except KeyError:
        return None

def get_dix_JSON(fileName):
    f = open_JSON(fileName)
    data = json.load(f)
    f.close()
    return data

def rotate(lista: list, n):
    return lista[n:] + lista[:n]

def make_project_dir(nomeProgetto, nomeCartella, binName, docName, fileName):
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

def create_java_and_readme_file(perBin, perDoc, intJava, intRead, projectName, readmeName):
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
    
    dix["nome_cartella"] = "demartini_F_"
    dix["readme_name"] = "README.md"
    dix["bin_name"] = "bin"
    dix["doc_name"] = "doc"
    dix["file_name"] = "file"
    dix["lenguage_selected"] = []
    dix["description"] = ""
    dix["auto_readme"] = False

    update_JSON('project_settings.json', dix)

    if boold:
        print("End")
