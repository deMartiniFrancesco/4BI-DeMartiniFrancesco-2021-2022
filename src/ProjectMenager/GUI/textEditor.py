# -*- coding: utf-8 -*-
__autor__ = "Francesco"
__version__ = "0101 2022/03/14"

from tkinter import *
import tkinter as tk
from tkinter.filedialog import *


def openTextEditor(window):
    
    def open_file():
        """Open a file for editing."""
        filepath = askopenfilename(
            filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")]
        )
        if not filepath:
            return
        txt_edit.delete(1.0, END)
        with open(filepath, "r") as input_file:
            text = input_file.read()
            txt_edit.insert(tk.END, text)
        window.title(f"Text Editor Application - {filepath}")


    def save_file():
        """Save the current file as a new file."""
        filepath = asksaveasfilename(
            defaultextension="txt",
            filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")],
        )
        if not filepath:
            return
        with open(filepath, "w") as output_file:
            text = txt_edit.get(1.0, END)
            output_file.write(text)
        window.title(f"Text Editor Application - {filepath}")

    window.rowconfigure(0, minsize=300, weight=1)
    window.columnconfigure(1, minsize=500, weight=1)
    txt_edit = Text(window)
    scrollbar = Scrollbar(txt_edit, orient="vertical")
    fr_buttons = Frame(window, relief=RAISED, bd=2)
    btn_open = Button(fr_buttons, text="Open", command=open_file)
    btn_save = Button(fr_buttons, text="Save As...", command=save_file)


    btn_open.grid(row=0, column=0, sticky="ew", padx=5, pady=5)
    btn_save.grid(row=1, column=0, sticky="ew", padx=5)

    fr_buttons.grid(row=0, column=0, sticky="ns")
    txt_edit.grid(row=0, column=1, sticky="nsew")

    


boold = True
if __name__ == "__main__":
    if boold:
        print("Start")


    window = Tk()
    window.title("Text Editor Application")
    
    

    openTextEditor(window)
    
    window.mainloop()
    
    if boold:
        print("End")
