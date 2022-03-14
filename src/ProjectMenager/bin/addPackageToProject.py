# -*- coding: utf-8 -*-
__autor__ = "Francesco"
__version__ = "0101 2021/11/30"

from projectLib import *


exist = False
percorso, tail = os.path.split(__file__)
os.chdir(percorso)

boold = True
if __name__ == '__main__':
    if boold:
        print("Start")
    # CONSTANTI
    nomeCartella = getKeyValueJSON('nomeCartella')
    readmeName = getKeyValueJSON('readmeName')
    binName = getKeyValueJSON('binName')
    docName = getKeyValueJSON('docName')
    fileName = getKeyValueJSON('fileName')

    projectListDir = os.listdir()

    for directory in projectListDir:
        if isdir(directory) and directory.startswith(nomeCartella):
            package = "package " + directory + "." + binName + ";\n"
            directory += "/" + binName + "/"
            if isdir(directory):
                for javaFilePath in os.listdir(directory):
                    javaFilePath = directory + javaFilePath
                    if isfile(javaFilePath) and javaFilePath.endswith(".java"):

                        javaFile = open(javaFilePath, "r", )
                        listLines = javaFile.readlines()
                        javaFile.close()

                        if package not in listLines:
                            print(javaFilePath)
                            listLines.insert(0, package + "\n")
                            javaFile = open(javaFilePath, "w", )
                            listLines = javaFile.writelines(listLines)
                            javaFile.close()

    if boold:
        print("End")
