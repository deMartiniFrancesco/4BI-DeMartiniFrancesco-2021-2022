# -*- coding: utf-8 -*-
__autor__ = "Francesco"
__version__ = "0101 2021/11/23"

import importlib
import os
import sys
from pathlib import Path


exist = False
percorso, tail = os.path.split(__file__)
os.chdir(percorso)


boold = False
if __name__ == '__main__':
    
    if boold:
        print("Start")


    clipBoard = []
    counterCapolinea = 1
    if not boold:
        print("inserire clipboard: ")
        while (counterCapolinea < 2):

            inputConsegna = input()
            clipBoard.append(inputConsegna.replace("        ", "\t") + "\n")

            if inputConsegna == "":
                counterCapolinea += 1
            else:
                counterCapolinea = 1
        functionStr = input("inserire funzone da eseguire\n1 - clipBoardToString\t\t2 - format clipBoard\n")
    else:
        clipBoard.append("'package ' + nomeCartella + projectName + '.bin;\n\n' + \\".replace("'", '"'))
        functionStr = "2"
    print("------------------------------------------------------------------------------------------------------------------------")

    if(functionStr == "1"):
        for string in clipBoard:
            print (repr(string) + " + \\")


    elif(functionStr == "2"):

        
        for i in range(len(clipBoard)):
            if(clipBoard[i].find("\n\n") > -1):
                clipBoard[i] = clipBoard[i].replace("\n\n", "\n")
                print(clipBoard)
                clipBoard.insert(i + 1, "\n + \\").decode('string_escape')
        print(repr(clipBoard[0]).replace("'", "").replace("\\", '\\'))
    print("------------------------------------------------------------------------------------------------------------------------")


    if boold:
        print("End")