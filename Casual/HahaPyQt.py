from kivy.app import App
from kivy.uix.button import Button


class TutorialApp(App):
    def build(self):
        return Button(text="Hello")


if __name__ == '__main__':
    TutorialApp().run()
    