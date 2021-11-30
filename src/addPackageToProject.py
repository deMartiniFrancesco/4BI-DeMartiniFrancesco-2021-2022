# -*- coding: utf-8 -*-
__autor__ = "Francesco"
__version__ = "0101 2021/11/30"

from genericpath import isdir
import os


exist = False
percorso, tail = os.path.split(__file__)
os.chdir(percorso)


boold = True
if __name__ == '__main__':
    if boold:
        print("Start")

    projectListDir = os.listdir()

    for dir in projectListDir:
        if isdir(dir) and dir.startswith("demartini"):
            print(dir)

    
    if boold:
        print("End")
