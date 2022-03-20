from pathlib import Path
import sys
from customtkinter import *

def import_parents(level):
    global __package__
    file = Path(__file__).resolve()
    parent, top = file.parent, file.parents[level]

    sys.path.append(str(top))
    try:
        sys.path.remove(str(parent))
    except ValueError:  # giá rimosso
        pass

    __package__ = '.'.join(parent.parts[len(top.parts):])


import_parents(2)
from .page_enum import PageEnum
from .pages.settings_page import SettingsPage
from .pages.new_project_page import NewProjectPage
from .pages.main_page import MainPage


# Modes: "System" (standard), "Dark", "Light"
set_appearance_mode("System")
# Themes: "blue" (standard), "green", "dark-blue"
set_default_color_theme("blue")


class App(CTk):

    WIDTH = 780
    HEIGHT = 520

    def __init__(self):
        super().__init__()

        self.title("Project Manager")
        self.geometry(f"{App.WIDTH}x{App.HEIGHT}")
        # self.minsize(App.WIDTH, App.HEIGHT)

        self.protocol("WM_DELETE_WINDOW", self.on_closing)
        if sys.platform == "darwin":
            self.bind("<Command-q>", self.on_closing)
            self.bind("<Command-w>", self.on_closing)
            self.createcommand('tk::mac::Quit', self.on_closing)

        # ============ create two frames ============

        # configure grid layout (1x2)
        self.grid_columnconfigure(1, weight=1)
        self.rowconfigure(0, weight=1)

        self.frame_left = CTkFrame(master=self,
                                   width=180,
                                   corner_radius=0)
        self.frame_left.grid(row=0, column=0, sticky="nswe")

        self.frame_right = MainPage(self)
        self.frame_right.grid(row=0, column=1, sticky="nswe", padx=20, pady=20)

        # ============ frame_left ============

        # configure grid layout
        # empty row with minsize as spacing
        self.frame_left.grid_rowconfigure(0, minsize=10)
        self.frame_left.grid_rowconfigure(5, weight=1)  # empty row as spacing
        # empty row with minsize as spacing
        self.frame_left.grid_rowconfigure(8, minsize=20)
        # empty row with minsize as spacing
        self.frame_left.grid_rowconfigure(11, minsize=10)

        self.label_1 = CTkLabel(master=self.frame_left,
                                text="ProjectManager",
                                text_font=("Roboto Medium", -16),
                                )  # font name and size in px
        self.label_1.grid(row=1, column=0, pady=10, padx=10)

        self.new_project_button = CTkButton(master=self.frame_left,
                                            text="Nuovo Progetto",
                                            # <- custom tuple-color
                                            fg_color=("gray75", "gray30"),
                                            command=lambda: self.change_page(PageEnum.NEW_PROJECT))
        self.new_project_button.grid(row=2, column=0, pady=10, padx=20)

        self.sort_project_button = CTkButton(master=self.frame_left,
                                             text="Ordina Progetti",
                                             # <- custom tuple-color
                                             fg_color=("gray75", "gray30"),
                                             command=lambda: self.change_page(PageEnum.SORT_PROJECT))
        self.sort_project_button.grid(row=3, column=0, pady=10, padx=20)

        self.settings_button = CTkButton(master=self.frame_left,
                                         text="Settings",
                                         fg_color=("gray75", "gray30"), # <- custom tuple-color
                                         command=lambda: self.change_page(PageEnum.SETTINGS))
        self.settings_button.grid(
            row=9, column=0, pady=10, padx=20, sticky="w")

        self.switch_dark_mode = CTkSwitch(master=self.frame_left,
                                          text="Dark Mode",
                                          command=self.change_mode)
        self.switch_dark_mode.select()
        self.switch_dark_mode.grid(
            row=10, column=0, pady=10, padx=20, sticky="w")

    def change_page(self, pageType):
        self.clear_frame_right()

        match pageType:
            case PageEnum.NEW_PROJECT:
                self.frame_right = NewProjectPage(self)

            case PageEnum.SORT_PROJECT:
                self.frame_right = SettingsPage(self)

            case PageEnum.SETTINGS:
                self.frame_right = SettingsPage(self)

            case _:
                self.frame_right = MainPage(self)

        self.frame_right.grid(row=0, column=1, sticky="nswe", padx=20, pady=20)

    def change_mode(self):
        if self.switch_dark_mode.get() == 1:
            set_appearance_mode("dark")
        else:
            set_appearance_mode("light")

    def clear_frame_right(self):
        self.frame_right.destroy()

    def on_closing(self, event=0):
        self.destroy()

    def start(self):
        self.mainloop()


if __name__ == "__main__":
    app = App()
    app.start()