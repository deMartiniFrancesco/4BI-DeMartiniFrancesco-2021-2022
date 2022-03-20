# -*- coding: utf-8 -*-
from genericpath import isdir, isfile
__autor__ = "Francesco"
__version__ = "0101 2022/03/14"

import os
import json
import re

percorso, tail = os.path.split(__file__)
os.chdir(percorso)

# CONSTANTI
pathSeparation = "//"

# ================== JSON functions ==================


def open_JSON(file_name):
    try:
        f = open('../file/' + file_name, 'r+')
        return f
    except FileNotFoundError:
        with open('../file/' + file_name, 'w') as f:
            json.dump({}, f, indent=4)
        return open_JSON(file_name)
    except:
        exit(1)


def update_key_JSON(file_name, key, value):
    f = open_JSON(file_name)
    data = json.load(f)
    data[key] = value
    f.seek(0)
    json.dump(data, f, indent=4)
    f.truncate()
    f.close()


def update_JSON(file_name, dix):
    for key, value in dix.items():
        update_key_JSON(file_name, key, value)


def get_key_value_JSON(file_name, key):
    f = open_JSON(file_name)
    data = json.load(f)
    f.close()
    try:
        return data[key]
    except KeyError:
        return ""


def get_dix_JSON(file_name):
    f = open_JSON(file_name)
    data = json.load(f)
    f.close()
    return data

# ================== create project functions ==================


def rotate(lista: list, n):
    return lista[n:] + lista[:n]


def make_project_dir(nomeProgetto, nomeCartella, binName, docName, file_name):
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

        perFile = cartella + pathSeparation + file_name
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

# ================== edit header functions ==================


def read_header(file_name):
    try:
        return open('../file/Headers/' + file_name, 'r+')
    except FileNotFoundError:
        open('../file/Headers/' + file_name, 'w')
        return read_header(file_name)
    except:
        exit(1)


def write_header(file_name):
    return open('../file/Headers/' + file_name, 'w')


def save_header(file_name, text):
    f = write_header(file_name)

    f.write(text)

    f.close()


def search_tags(file_name):
    f = read_header(file_name)
    list_lines = f.readlines()
    f.close()

    pattern = re.compile("{%.*%}")

    for line in list_lines:
        matchs = pattern.findall(line)
        for keys in matchs:
            key_string = get_key_value_JSON(keys.strip("{%%}"))
            if not key_string == None:
                print(key_string)


def get_tags(file_name):
    tag_list: list = get_key_value_JSON(file_name, "tags")
    stringa: str = ""
    for tag in tag_list:
        stringa += "{%" + tag + "%}" + "\n"
    return stringa


def header_avable():
    return os.listdir('../file/Headers/')


def get_header_text(file_name):
    f = read_header(file_name)
    list_lines = f.readlines()
    f.close()

    string = ""
    for line in list_lines:
        string += line
    return string


boold = True
if __name__ == "__main__":
    if boold:
        print("Start")

    dix = {}

    # ========= project_settings.json =========

    # dix["prefisso_cartella"] = "demartini_F_"
    # dix["nome_readme"] = "README.md"
    # dix["cartella_bin"] = "bin"
    # dix["cartella_doc"] = "doc"
    # dix["cartella_file"] = "file"
    # dix["linguaggi_selezionati"] = []
    # dix["nome_progetto"] = ""
    # dix["descrizione"] = ""
    # dix["auto_readme"] = False

    # update_JSON('project_settings.json', dix)

    # ========= config.json =========

    # dix["supported_leguages"] = ["java", "python"]
    # dix["tags"] = ["prefisso_cartella", "nome_readme", "cartella_bin",
    #                "cartella_doc", "cartella_file", "descrizione", "nome_progetto",
    #                "auto_readme"]
    # dix["work_space_name"] = "src"

    # update_JSON('config.json', dix)

    print(get_tags("config.json"))

    if boold:
        print("End")
