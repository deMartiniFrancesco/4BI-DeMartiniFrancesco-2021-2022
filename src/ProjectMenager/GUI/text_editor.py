# -*- coding: utf-8 -*-
__autor__ = "Francesco"
__version__ = "0101 2022/03/14"

from tkinter import *
import tkinter as tk
from tkinter import messagebox
from tkinter.filedialog import *


class TextEditor(Frame):
    def __init__(self, master, *args, **kwargs):
        Frame.__init__(self, master, *args, **kwargs)

        root.protocol("WM_DELETE_WINDOW", self.on_closing)

        self.rowconfigure(0, minsize=300, weight=1)
        self.columnconfigure(1, minsize=500, weight=1)

        self.txt_edit = Text(self)
        scrollbar = Scrollbar(self.txt_edit, orient="vertical")
        fr_buttons = Frame(self, relief=RAISED, bd=2)
        btn_open = Button(fr_buttons, text="Open", command=self.open_file)
        btn_save = Button(fr_buttons, text="Save", command=self.save_file)

        btn_open.grid(row=0, column=0, sticky="ew", padx=5, pady=5)
        btn_save.grid(row=1, column=0, sticky="ew", padx=5)

        fr_buttons.grid(row=0, column=0, sticky="ns")
        self.txt_edit.grid(row=0, column=1, sticky="nsew")

        self.currentFilePath = None


    def open_file(self):
        """Open a file for editing."""
        filepath = askopenfilename(
            filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")]
        )
        if not filepath:
            messagebox.showerror('Open file', 'No file selected!')
            return
        self.txt_edit.delete(1.0, END)
        self.currentFilePath = filepath
        with open(filepath, "r") as input_file:
            text = input_file.read()
            self.txt_edit.insert(tk.END, text)

    def save_file(self):
        """Save the current file."""
        if not self.currentFilePath:
            messagebox.showerror('Saving', 'No file selected!')
            return
        with open(self.currentFilePath, "w") as output_file:
            text = self.txt_edit.get(1.0, END)
            output_file.write(text)
        messagebox.showinfo('Saving', 'File currect saved!')
        self.txt_edit.edit_modified(False)

    def on_closing(self):
        if self.txt_edit.edit_modified():
            if messagebox.askokcancel("Quit", "Unsaved file, Do you want to save?"):
                self.save_file()
                root.destroy()
        else:
            root.destroy()

boold = True
if __name__ == "__main__":
    if boold:
        print("Start")

    root = Tk()
    root.title("Text Editor Application")

    TextEditor(root).pack(side="top", fill="both", expand=True)

    root.mainloop()

    if boold:
        print("End")
