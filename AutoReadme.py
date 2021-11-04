# -*- coding: utf-8 -*-
__autor__ = "Francesco"
__version__ = "0101 2020/10/12"

import os

head, tail = os.path.split(__file__)
os.chdir(head)
percorso = os.getcwd()

boold = True
if __name__ == "__main__":
    if boold:
        print("Start")

    # README
    intestazioneMD = """# DeMartiniFrancesco-4BI-2021-2022
---
## Project
"""




    srcDirectory = "./src/"
    srcGitDirectory = "https://github.com/deMartiniFrancesco/DeMartiniFrancesco-4BI-2021-2022/tree/master/src/"

    with open("README.md") as f:
        f.writelines(intestazioneMD)

        for dir in os.listdir(srcDirectory):
            if dir.startswith("demartini"):
                f.write(srcGitDirectory + dir)
            else:
                continue

    if boold:
        print("End")
