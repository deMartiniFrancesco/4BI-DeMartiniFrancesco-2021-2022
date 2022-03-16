# -*- coding: utf-8 -*-
__autor__ = "Francesco"
__version__ = "0101 2022/03/16"

from tkinter import *
from customtkinter import *
from tkinter.filedialog import *


class SettingsPage(CTkFrame):
    def __init__(self, master, *args, **kwargs):
        CTkFrame.__init__(self, master=master, width=250, height=240, corner_radius=15)

        set_appearance_mode("Dark")  
        set_default_color_theme("blue")  


        self.grid(row=0, column=0, padx=20, pady=20, sticky="nsew")

        self.grid_columnconfigure(0, weight=1)
        self.grid_columnconfigure(1, weight=1)
        self.grid_rowconfigure(0, minsize=10)  # add empty row for spac

        button_1 = CTkButton(
            master=self, text="Edit Headers", command=self.clear_frame)
        button_1.grid(row=1, column=0, columnspan=2,
                      padx=20, pady=10, sticky="ew")

        button_2 = CTkButton(
            master=self, text="Edit Variables", command=self.clear_frame)
        button_2.grid(row=2, column=0, columnspan=2,
                      padx=20, pady=10, sticky="ew")

        button_3 = CTkButton(
            master=self, text="Edit Flags", command=self.clear_frame)
        button_3.grid(row=3, column=0, columnspan=2,
                      padx=20, pady=10, sticky="ew")

        button_4 = CTkButton(
            master=self, text="Back", command=self.clear_frame)
        button_4.grid(row=4, column=1, columnspan=1,
                      padx=20, pady=10, sticky="e")

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

    SettingsPage(root)

    root.mainloop()

    if boold:
        print("End")
