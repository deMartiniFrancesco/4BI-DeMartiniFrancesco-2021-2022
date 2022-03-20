# -*- coding: utf-8 -*-
__autor__="Francesco"
__version__="0101 2022/03/14"

import re
from project_lib import *

exist = False
percorso, tail = os.path.split(__file__)
os.chdir(percorso)


def readHeader(headerFileName):
    with open(headerFileName, 'r+') as f:
        return f.readlines()


def searchTags(listLines):

    pattern = re.compile("{%.*%}")
    
    for line in listLines:
        matchs = pattern.findall(line)
        for keys in matchs:
            keyString = get_key_value_JSON(keys.strip("{%%}"))
            if not keyString == None:
                print(keyString)


boold = True
if __name__ == "__main__":
    if boold:
        print("Start")


    headerAvable = os.listdir('../file/Headers/')
    print(headerAvable)


    searchTags(readHeader('../file/Headers/JavaHeader.txt'))

    if boold:
        print("End")
