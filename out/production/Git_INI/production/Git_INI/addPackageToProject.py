# -*- coding: utf-8 -*-
__autor__ = "Francesco"
__version__ = "0101 2021/11/30"

from genericpath import isdir, isfile
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
			package = "package " + dir + ".bin;\n"
			dir += "/bin/"
			if isdir(dir):
				for javaFilePath in os.listdir(dir):
					javaFilePath = dir + javaFilePath
					if isfile(javaFilePath) and javaFilePath.endswith(".java"):
						

						javaFile = open(javaFilePath, "r",)
						listLines = javaFile.readlines()
						javaFile.close()

						if(package not in listLines):
							print(javaFilePath)
							listLines.insert(0, package + "\n")
							javaFile = open(javaFilePath, "w",)
							listLines = javaFile.writelines(listLines)
							javaFile.close()
	
	if boold:
		print("End")
