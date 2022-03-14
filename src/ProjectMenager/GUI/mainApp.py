# -*- coding: utf-8 -*-
from tkinter import *
__autor__ = "Francesco"
__version__ = "0101 2022/03/14"


class MainApplication(Frame):
    def __init__(self, master, *args, **kwargs):
        Frame.__init__(self, master, *args, **kwargs)

        self.columnconfigure(1, weight=1)
        self.columnconfigure(3, pad=7)
        self.rowconfigure(3, weight=1)
        self.rowconfigure(5, pad=7)


    
        Button(self, text="Nuovo progetto", command=self.clear_frame).grid(row=1, column=1)
        Button(self, text="Ordina progetti", command=self.clear_frame).grid(row=2, column=1)
        Button(self, text="Settings", command=self.clear_frame).grid(row=1, column=3)
        Button(self, text="Clear", command=self.clear_frame).grid(row=5, column=3)
     


    def clear_frame(self):
        for widgets in self.winfo_children():
            widgets.destroy()

    def backItem(self):
        Button(self, text="Clear", font=('Helvetica bold', 10),
            command=self.clear_frame).pack(pady=20)


boold = True
if __name__ == "__main__":
    if boold:
        print("Start")

    root = Tk()
    root.title("ProjectMenager")
    root.geometry("350x300+300+300")

    MainApplication(root).pack(side="top", fill="both", expand=True)

    root.mainloop()
    if boold:
        print("End")
