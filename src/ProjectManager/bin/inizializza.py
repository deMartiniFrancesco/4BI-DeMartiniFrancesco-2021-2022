# -*- coding: utf-8 -*-
__autor__ = "Francesco"
__version__ = "0101 2021/10/12"

# TODO modificare scrittura README encoding sbagliata

import importlib
from pathlib import Path
import sys
from project_lib import *

exist = False
percorso, tail = os.path.split(__file__)
os.chdir(percorso)


def import_parents(level):
    global __package__
    file = Path(__file__).resolve()
    parent, top = file.parent, file.parents[level]

    sys.path.append(str(top))
    try:
        sys.path.remove(str(parent))
    except ValueError:  # giá rimosso
        pass

    __package__ = '.'.join(parent.parts[len(top.parts):])
    importlib.import_module(__package__)  # won't be needed after that


# CONSTANTI
nomeCartella = get_key_value_JSON('nomeCartella')
readmeName = get_key_value_JSON('readmeName')
binName = get_key_value_JSON('binName')
docName = get_key_value_JSON('docName')
fileName = get_key_value_JSON('fileName')


boold = True
if __name__ == '__main__' and __package__ is None:
    try:
        import_parents(level=3)
        from ... import AutoReadme
        importNoError = True
    except ImportError:
        importNoError = False

    if boold:
        print("Start")

    # INPUT
    projectName = input("inserire nome progetto: ").capitalize()
    consegna = ""
    counterCapolinea = 1

    print("inserire consegna progetto: ")
    while counterCapolinea < 3:

        inputConsegna = input()
        consegna += inputConsegna + "\n"

        if inputConsegna == "":
            counterCapolinea += 1
        else:
            counterCapolinea = 1

    if importNoError:
        generateReadme = input(
            "Generare README (y/n): ").lower() in ("yes", "true", "y", "ye", "si", "s", "ok")


    # OUTPUT
    exist, perBin, perDoc, perFile, dirUpdated = make_project_dir(
        projectName, nomeCartella, binName, docName, fileName)

    if not exist:
        creation = create_java_and_readme_file(
            perBin, perDoc, headerJava, headerMd, projectName, readmeName)
        if creation and generateReadme:
            AutoReadme.updateMD(percorso, nomeCartella, dirUpdated)
        elif(not creation):
            print("Erroe on write files")
    else:
        print(exist)

    if boold:
        print("End")
