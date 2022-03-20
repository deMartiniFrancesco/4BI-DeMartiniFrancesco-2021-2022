# -*- coding: utf-8 -*-
__autor__ = "Francesco"
__version__ = "0101 2022/03/16"

from customtkinter import *

class SettingsPage(CTkFrame):
    def __init__(self, master):

        super().__init__(master)

        # configure grid layout (3x7)
        for i in [0, 1, 2, 3]:
            self.rowconfigure(i, weight=1)
        self.rowconfigure(7, weight=10)
        self.columnconfigure(0, weight=1)
        self.columnconfigure(1, weight=1)

        button_1 = CTkButton(
            master=self, text="Edit Headers", command=self.clear_frame)
        button_1.grid(row=0, column=0, columnspan=2,
                      padx=20, pady=10, sticky="ew")

        button_2 = CTkButton(
            master=self, text="Edit Variables", command=self.clear_frame)
        button_2.grid(row=1, column=0, columnspan=2,
                      padx=20, pady=10, sticky="ew")

        button_3 = CTkButton(
            master=self, text="Edit Flags", command=self.clear_frame)
        button_3.grid(row=2, column=0, columnspan=2,
                      padx=20, pady=10, sticky="ew")

        button_4 = CTkButton(
            master=self, text="Back", command=self.clear_frame)
        button_4.grid(row=3, column=1, columnspan=1,
                      padx=20, pady=10, sticky="e")

    def clear_frame(self):
        for widgets in self.winfo_children():
            widgets.destroy()
